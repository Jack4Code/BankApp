/**
 * Created by Jack on 12/18/2017.
 */



function httpGetData(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            console.log(xmlHttp.responseText);
            data =  xmlHttp.responseText;
        }
    }
    xmlHttp.open("GET", theUrl, false); //true for asynchromous
    xmlHttp.send();
}

httpGetData("http://10.0.0.186:8081/entry-point/get-accounts");
