package labka;

class AudioSystem {
    void TurnOn(){
        System.out.println("audio turn on");
    }

    void TurnOff(){
        System.out.println("audio turn off");
    }
    void Valume(double va){
        System.out.println("Valume: "+va);
    }
}
class VideoProjector {
    void TurnOn(){
        System.out.println("video turn on");
    }

    void TurnOff(){
        System.out.println("video turn off");
    }
    void Model(String m){
        System.out.println("Model: "+m);
    }
}

class LightingSystem {
    void TurnOn(){
        System.out.println("light turn on");
    }

    void TurnOff(){
        System.out.println("light turn off");
    }
    void Yarkost(double va){
        System.out.println("Yarkost: "+va);
    }
}
class HomeTheaterFacade{
    private AudioSystem _audioSystem;
    private VideoProjector _videoProjector;
    private LightingSystem _lightingSystem;

    public HomeTheaterFacade(AudioSystem _audioSystem, VideoProjector _videoProjector, LightingSystem _lightingSystem) {
        this._audioSystem = _audioSystem;
        this._videoProjector = _videoProjector;
        this._lightingSystem = _lightingSystem;
    }
    void start(){
        _audioSystem.TurnOn();
        _audioSystem.Valume(25);
        _lightingSystem.TurnOn();
        _lightingSystem.Yarkost(32);
        _videoProjector.TurnOn();
        _videoProjector.Model("Samsung");
        System.out.println("movie started");
    }

    void end(){
        _audioSystem.TurnOff();
        _lightingSystem.TurnOff();
        _videoProjector.TurnOff();
        System.out.println("movie ended");
    }
}
class Main{
    public static void main(String[] args) {
        AudioSystem audioSystem = new AudioSystem();
        LightingSystem lightingSystem = new LightingSystem();
        VideoProjector videoProjector = new VideoProjector();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(audioSystem,videoProjector,lightingSystem);
        homeTheaterFacade.start();
        System.out.println("---------------");
        homeTheaterFacade.end();
    }
}