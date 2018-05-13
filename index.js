function onLoad()
{
     document.getElementById("loader").style.display = "none";
}
function showLoader() {
    
    document.getElementById("loader").style.display = "block";
    setTimeout(showLoader,3000)
};


function mute_music(){
    var music = document.getElementById("bk_music");
    music.muted = true;

  
} 

function unmute_music(){
    var music = document.getElementById("bk_music");
    music.muted = false; 
}
