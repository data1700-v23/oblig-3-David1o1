const kundene = [];
function kjopBillett(){

    //henter data fra input-felt
    const bille = {
        film: $("#film").val(),
        antall: $("#antall").val(),
        navn: $("#navn").val(),
        etterNavn: $("#etterNavn").val(),
        telefon: $("#telefon").val(),
        epost: $("#epost").val()
    }
    //sender billett til serveren, og skriver ut
    $.post("/lagre",bille,function(){
        skrivUt()
        $("film").val("Velg film her")
        $("antall").val("")
        $("navn").val("")
        $("etterNavn").val("")
        $("telefon").val("")
        $("epost").val("");

        document.getElementById("feilAntall").innerText= ""
        document.getElementById("feilNavn").innerText = ""
        document.getElementById("feilEtterNavn").innerText= ""
        document.getElementById("feilTel").innerText = ""
        document.getElementById("feilEpost").innerText = ""

    })
}

//Skriver ut funksjonen
function skrivUt(){
    $.get("/send", function (kundene){
        let billettUt = "<table>" +
            "<tr><th>Film</th>" +
            "<th>Antall</th>" +
            "<th>Fornavn</th>" +
            "<th>Etternavn</th>" +
            "<th>Telefonnr</th>" +
            "<th>Epost</th></tr>";

        for(let etKjop of kundene){
            billettUt += "<tr><td>" + etKjop.film + "</td><td>" + etKjop.antall + "</td><td>" + etKjop.navn +
                "</td><td>" + etKjop.etterNavn + "</td><td>" + etKjop.telefon + "</td><td>"
                + etKjop.epost + "</td></tr>"
        }
        billettUt += "</table>";
        $("#kjopet").html(billettUt);
    })
}

let utskrift;
let error = false;

if(bille.antall <= 0){
    utskrift = "Du må skrive noe inn i antall";
    document.getElementById("feilAntall").innerHTML=utskrift;
    error = true;
}
else{
    document.getElementById("feilAntall").innerHTML = "";
}
if (bille.navn === ""){
    utskrift = "Du må skrive noe inn i fornavn";
    document.getElementById("feilNavn").innerHTML=utskrift;
    error = true;
}
if (bille.etterNavn === ""){
    utskrift = "Du må skrive noe inn i etternavn";
    document.getElementById("feilEtterNavn").innerHTML=utskrift;
    error = true;
}
if (bille.telefon.length !== 8){
    utskrift = "Du må skrive noe inn i telefon";
    document.getElementById("feilTel").innerHTML=utskrift;
    error = true;
}

if (bille.epost === ""){
    utskrift = "Du må skrive noe inn i epost";
    document.getElementById("feilEpost").innerHTML=utskrift;
    error = true;
}

if(!error){
    document.getElementById("film").value= "";
    document.getElementById("antall").value= "";
    document.getElementById("navn").value= "";
    document.getElementById("etterNavn").value= "";
    document.getElementById("telefon").value= "";
    document.getElementById("epost").value= "";
    kundene.push(bille);
}


//sletter arrayet for billettene
function slettBillett(){
    $.post("/slett", function (){
        $("#kjopet").html("");
    })
}