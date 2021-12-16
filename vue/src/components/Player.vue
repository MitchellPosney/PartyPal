<template>
    <div>
        <h1>Playlist</h1>
        <img src="/play.png" id="playpauseimg">

    </div>
</template>
<script>
export default {
    name: 'playlist',
    methods: {
        changePlayPauseImg() {
            var image = document.getElementById('playpauseimg');
            if(image.src.match("/play.png")) {
                document.getElementById('playPauseImg').src='pause.png';
            } else {
                document.getElementById('playPauseImg').src='play.png';
            }
        }
    }
    
}
</script>
<style>

</style>