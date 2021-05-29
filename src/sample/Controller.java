package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import Model.ImageCollection;
import Model.Iterator;
import javafx.event.EventHandler;



public class Controller {

    public ImageCollection imgs =new ImageCollection("");
    public Iterator iter_main = imgs.getIterator();
    public ImageView Img;
    public Timeline timeline =new Timeline();
    public void initialize()
    {
        timeline.setCycleCount(Timeline.INDEFINITE);//кол-во повторов
        Duration dur =new Duration(2000);
        EventHandler EH = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    Img.setImage(name);
                }
            }
        };
        KeyFrame KF=  new KeyFrame(dur, EH);
        timeline.getKeyFrames().add(KF);
    }

    public void Start(ActionEvent actionEvent) {
        timeline.play();
    }
    public void Stop(ActionEvent actionEvent) {
        timeline.stop();
    }
    public void back(ActionEvent actionEvent) {
        if (iter_main.hasBack()) {
            Image name = (Image) iter_main.preview();
            Img.setImage(name);
        }
    }
    public void next(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            Img.setImage(name);
        }
    }
}

