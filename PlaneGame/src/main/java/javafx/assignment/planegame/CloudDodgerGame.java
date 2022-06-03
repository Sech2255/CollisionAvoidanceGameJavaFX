package javafx.assignment.planegame;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class CloudDodgerGame extends Application {

    final Double rootDimHeight = 500.0;
    final Double rootDimWidth = 910.0;

    final Double cloudRate = 0.9;

    int gameScore = 0;

    Button exitButton = new Button("Exit Game");

    Label gameScoreLabel = new Label("Score: " + gameScore);

    Label gameResultsLabel = new Label();

    Label gameStatus = new Label();

    String cloudString = "cloud2.png";

    Rectangle skyLimit= new Rectangle(910, 5);

    Rectangle ground = new Rectangle(910, 50);

    //Cloud Rectangle 1 ***************************************
    Rectangle cloudRectangle1 = new Rectangle(100, 50);
    TranslateTransition cloudTranslate1 = new TranslateTransition();
    Image cloudImg1 = new Image(cloudString);
    ImagePattern imgPatCloud1 = new ImagePattern(cloudImg1);
    //*********************************************************

    //Cloud Rectangle 2 ***************************************
    Rectangle cloudRectangle2 = new Rectangle(100, 50);
    TranslateTransition cloudTranslate2 = new TranslateTransition();
    Image cloudImg2 = new Image(cloudString);
    ImagePattern imgPatCloud2 = new ImagePattern(cloudImg2);
    //*********************************************************

    //Cloud Rectangle 3 ***************************************
    Rectangle cloudRectangle3 = new Rectangle(100, 50);
    TranslateTransition cloudTranslate3 = new TranslateTransition();
    Image cloudImg3 = new Image(cloudString);
    ImagePattern imgPatCloud3 = new ImagePattern(cloudImg3);
    //*********************************************************

    Rectangle cloudRectangle4 = new Rectangle(100, 50);
    TranslateTransition cloudTranslate4 = new TranslateTransition();
    Image cloudImg4 = new Image(cloudString);
    ImagePattern imgPatCloud4 = new ImagePattern(cloudImg4);
    //*********************************************************

    Rectangle cloudRectangle5 = new Rectangle(100, 50);
    TranslateTransition cloudTranslate5 = new TranslateTransition();
    Image cloudImg5 = new Image(cloudString);
    ImagePattern imgPatCloud5 = new ImagePattern(cloudImg5);
    //*********************************************************

    //Plane Rectangle *****************************************
    Rectangle planeRectangle = new Rectangle(100, 50);

    Image planeImg = new Image("RotorPlane.png");
    ImagePattern imgPatPlane= new ImagePattern(planeImg);
    //*********************************************************

    //Coin Rectangle *****************************************
    Rectangle coin = new Rectangle(20, 30);
    TranslateTransition coinTranslation = new TranslateTransition();
    Image coinImg = new Image("goldcoin.png");
    ImagePattern imgPatCoin= new ImagePattern(coinImg);
    //*********************************************************

    //Coin Rectangle2 *****************************************
    Rectangle coin2 = new Rectangle(20, 30);
    TranslateTransition coinTranslation2 = new TranslateTransition();
    Image coinImg2 = new Image("goldcoin.png");
    ImagePattern imgPatCoin2= new ImagePattern(coinImg2);
    //*********************************************************

    //Coin Rectangle3 *****************************************
    Rectangle coin3 = new Rectangle(20, 30);
    TranslateTransition coinTranslation3 = new TranslateTransition();
    Image coinImg3 = new Image("goldcoin.png");
    ImagePattern imgPatCoin3= new ImagePattern(coinImg3);
    //*********************************************************

    //Coin Rectangle4 *****************************************
    Rectangle coin4 = new Rectangle(20, 30);
    TranslateTransition coinTranslation4 = new TranslateTransition();
    Image coinImg4 = new Image("goldcoin.png");
    ImagePattern imgPatCoin4= new ImagePattern(coinImg4);
    //*********************************************************

    //Coin Rectangle5 *****************************************
    Rectangle coin5 = new Rectangle(20, 30);
    TranslateTransition coinTranslation5 = new TranslateTransition();
    Image coinImg5 = new Image("goldcoin.png");
    ImagePattern imgPatCoin5= new ImagePattern(coinImg5);
    //*********************************************************

    Pane root = new Pane();

    Scene scene = new Scene(root, rootDimWidth, rootDimHeight);


    AnimationTimer collisionTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollision();

        }
    };


    @Override
    public void start(Stage stage) {

        startGame(scene);

        scene.getStylesheets().add("style.css");

        collisionTimer.start();

        gameStatus.setTextFill(Color.web("#1E90FF"));

        gameResultsLabel.setTextFill(Color.web("FFD700"));

        gameScoreLabel.setFont(new Font("Ubuntu Mono", 20));
        gameScoreLabel.setTextFill(Color.ORANGE);

        Rectangle cloud1 = createCloud1();
        Rectangle cloud2 = createCloud2();
        Rectangle cloud3 = createCloud3();
        Rectangle cloud4 = createCloud4();
        Rectangle cloud5 = createCloud5();

        Rectangle coin_1 = createCoin1();
        Rectangle coin_2 = createCoin2();
        Rectangle coin_3 = createCoin3();
        Rectangle coin_4 = createCoin4();
        Rectangle coin_5 = createCoin5();

        Rectangle skyLimit = createSkyLimit();
        Rectangle ground = createGround();
        Rectangle plane = Plane(scene);
        Button exitGame = exitBtn();

        root.getChildren().addAll(cloud1, cloud2, cloud3,cloud4, cloud5, coin_1, coin_2, coin_3,
                coin_4, coin_5, skyLimit, ground, plane, gameStatus, gameScoreLabel, exitGame);

        root.getChildren().add(gameResultsLabel);

        checkCollision();

        stage.setTitle("Cloud Dodger");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    private Rectangle createGround(){
        ground.setX(0);
        ground.setY(450);
        ground.setFill(Color.TRANSPARENT);
        return ground;
    }

    private Rectangle createSkyLimit(){
        skyLimit.setX(0);
        skyLimit.setY(0);
        skyLimit.setFill(Color.TRANSPARENT);
        return skyLimit;
    }


    private Rectangle createCloud1(){
        cloudRectangle1.setFill(imgPatCloud1);
        cloudRectangle1.setX(-150);
        cloudRectangle1.setY(50);

        cloudTranslate1.setNode(cloudRectangle1);
        cloudTranslate1.setDuration(Duration.seconds(4));
        cloudTranslate1.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTranslate1.setDelay(Duration.seconds(2.5));
        cloudTranslate1.setFromX(scene.getWidth()+300);
        cloudTranslate1.setToX(-300);
        cloudTranslate1.setByY(0);
        cloudTranslate1.setAutoReverse(false);
        cloudTranslate1.setRate(cloudRate);

        return cloudRectangle1;
    }

    private Rectangle createCloud2(){
        cloudRectangle2.setFill(imgPatCloud2);
        cloudRectangle2.setX(-150);
        cloudRectangle2.setY(400);

        cloudTranslate2.setNode(cloudRectangle2);
        cloudTranslate2.setDuration(Duration.seconds(4));
        cloudTranslate2.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTranslate2.setDelay(Duration.seconds(2.5));
        cloudTranslate2.setFromX(scene.getWidth()+300);
        cloudTranslate2.setToX(-300);
        cloudTranslate2.setByY(0);
        cloudTranslate2.setAutoReverse(false);
        cloudTranslate2.setRate(cloudRate);

        return cloudRectangle2;
    }

    private Rectangle createCloud3(){
        cloudRectangle3.setFill(imgPatCloud3);
        cloudRectangle3.setX(-150);
        cloudRectangle3.setY(220);

        cloudTranslate3.setNode(cloudRectangle3);
        cloudTranslate3.setDuration(Duration.seconds(4));
        cloudTranslate3.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTranslate3.setDelay(Duration.seconds(3.5));
        cloudTranslate3.setFromX(scene.getWidth()+300);
        cloudTranslate3.setToX(-300);
        cloudTranslate3.setByY(0);
        cloudTranslate3.setAutoReverse(false);
        cloudTranslate3.setRate(cloudRate);

        return cloudRectangle3;
    }

    private Rectangle createCloud4(){
        cloudRectangle4.setFill(imgPatCloud4);
        cloudRectangle4.setX(-150);
        cloudRectangle4.setY(50);

        cloudTranslate4.setNode(cloudRectangle4);
        cloudTranslate4.setDuration(Duration.seconds(4));
        cloudTranslate4.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTranslate4.setDelay(Duration.seconds(4.5));
        cloudTranslate4.setFromX(scene.getWidth()+300);
        cloudTranslate4.setToX(-300);
        cloudTranslate4.setByY(0);
        cloudTranslate4.setAutoReverse(false);
        cloudTranslate4.setRate(cloudRate);

        return cloudRectangle4;
    }

    private Rectangle createCloud5(){
        cloudRectangle5.setFill(imgPatCloud5);
        cloudRectangle5.setX(-150);
        cloudRectangle5.setY(400);

        cloudTranslate5.setNode(cloudRectangle5);
        cloudTranslate5.setDuration(Duration.seconds(4));
        cloudTranslate5.setCycleCount(TranslateTransition.INDEFINITE);
        cloudTranslate5.setDelay(Duration.seconds(4.5));
        cloudTranslate5.setFromX(scene.getWidth()+300);
        cloudTranslate5.setToX(-300);
        cloudTranslate5.setByY(0);
        cloudTranslate5.setAutoReverse(false);
        cloudTranslate5.setRate(cloudRate);

        return cloudRectangle5;
    }

    private Rectangle Plane(Scene scene){
        planeRectangle.setFill(imgPatPlane);
        planeRectangle.setX(root.getWidth() / 4);
        planeRectangle.setY(root.getHeight() / 3);

        final int[] keyX = {0};
        final int[] keyY = {0};

        scene.setOnKeyPressed(e->{
            switch (e.getCode()){
                case RIGHT:
                    keyX[0] = keyX[0] + 10;
                    planeRectangle.setTranslateX(keyX[0]);
                    break;

                case LEFT:
                    keyX[0] = keyX[0] - 10;
                    planeRectangle.setTranslateX(keyX[0]);
                    break;
                case UP:
                    keyY[0] = keyY[0] - 10;
                    planeRectangle.setTranslateY(keyY[0]);
                    break;

                case DOWN:
                    keyY[0] = keyY[0] + 10;
                    planeRectangle.setTranslateY(keyY[0]);
                    break;
            }
        });

        return planeRectangle;
    }

    private Rectangle createCoin1(){
        coin.setFill(imgPatCoin);
        coin.setX(-155);
        coin.setY(220);

        coinTranslation.setNode(coin);
        coinTranslation.setDuration(Duration.seconds(4));
        coinTranslation.setCycleCount(TranslateTransition.INDEFINITE);
        coinTranslation.setDelay(Duration.seconds(2.5));
        coinTranslation.setFromX(scene.getWidth()+400);
        coinTranslation.setToX(-300);
        coinTranslation.setByY(0);
        coinTranslation.setAutoReverse(false);
        coinTranslation.setRate(cloudRate);

        return coin;
    }

    private Rectangle createCoin2(){
        coin2.setFill(imgPatCoin2);
        coin2.setX(-155);
        coin2.setY(50);

        coinTranslation2.setNode(coin2);
        coinTranslation2.setDuration(Duration.seconds(4));
        coinTranslation2.setCycleCount(TranslateTransition.INDEFINITE);
        coinTranslation2.setDelay(Duration.seconds(3.5));
        coinTranslation2.setFromX(scene.getWidth()+400);
        coinTranslation2.setToX(-300);
        coinTranslation2.setByY(0);
        coinTranslation2.setAutoReverse(false);
        coinTranslation2.setRate(cloudRate);

        return coin2;
    }

    private Rectangle createCoin3(){
        coin3.setFill(imgPatCoin3);
        coin3.setX(-155);
        coin3.setY(300);

        coinTranslation3.setNode(coin3);
        coinTranslation3.setDuration(Duration.seconds(4));
        coinTranslation3.setCycleCount(TranslateTransition.INDEFINITE);
        coinTranslation3.setDelay(Duration.seconds(3));
        coinTranslation3.setFromX(scene.getWidth()+400);
        coinTranslation3.setToX(-300);
        coinTranslation3.setByY(0);
        coinTranslation3.setAutoReverse(false);
        coinTranslation3.setRate(cloudRate);

        return coin3;
    }

    private Rectangle createCoin4(){
        coin4.setFill(imgPatCoin4);
        coin4.setX(-155);
        coin4.setY(400);

        coinTranslation4.setNode(coin4);
        coinTranslation4.setDuration(Duration.seconds(4));
        coinTranslation4.setCycleCount(TranslateTransition.INDEFINITE);
        coinTranslation4.setDelay(Duration.seconds(3.5));
        coinTranslation4.setFromX(scene.getWidth()+400);
        coinTranslation4.setToX(-300);
        coinTranslation4.setByY(0);
        coinTranslation4.setAutoReverse(false);
        coinTranslation4.setRate(cloudRate);

        return coin4;
    }

    private Rectangle createCoin5(){
        coin5.setFill(imgPatCoin5);
        coin5.setX(-155);
        coin5.setY(220);

        coinTranslation5.setNode(coin5);
        coinTranslation5.setDuration(Duration.seconds(4));
        coinTranslation5.setCycleCount(TranslateTransition.INDEFINITE);
        coinTranslation5.setDelay(Duration.seconds(4.5));
        coinTranslation5.setFromX(scene.getWidth()+400);
        coinTranslation5.setToX(-300);
        coinTranslation5.setByY(0);
        coinTranslation5.setAutoReverse(false);
        coinTranslation5.setRate(cloudRate);

        return coin5;
    }

    public void checkCollision(){
        if((planeRectangle.getBoundsInParent().intersects(cloudRectangle1.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(cloudRectangle2.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(cloudRectangle3.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(cloudRectangle4.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(cloudRectangle5.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(skyLimit.getBoundsInParent()))
                ||(planeRectangle.getBoundsInParent().intersects(ground.getBoundsInParent()))
        ){
            gameStatus.setText("Game Over");
            gameStatus.setFont(new Font("Ubuntu Mono", 100));
            gameStatus.setLayoutY(rootDimHeight/3);
            gameStatus.setLayoutX(rootDimWidth/3.5);

            //scoreTimer.cancel();
            gameResultsLabel.setText("\nScore: " + gameScore/29);
            gameResultsLabel.setFont(new Font("Ubuntu Mono", 50));
            gameResultsLabel.setLayoutY(rootDimHeight/2);
            gameResultsLabel.setLayoutX(rootDimWidth/2.5);

            exitButton.setLayoutX(rootDimWidth/2.1);
            exitButton.setLayoutY(rootDimHeight/1.3);

            cloudTranslate1.stop();
            cloudTranslate2.stop();
            cloudTranslate3.stop();
            cloudTranslate4.stop();
            cloudTranslate5.stop();

            coinTranslation.stop();
            coinTranslation2.stop();
            coinTranslation3.stop();
            coinTranslation4.stop();
            coinTranslation5.stop();


            gameScoreLabel.setVisible(false);
            exitButton.setVisible(true);
            root.getChildren().remove(planeRectangle);

        }
        else {

            if(planeRectangle.getBoundsInParent().intersects(coin.getBoundsInParent())){
                gameScore = gameScore+1;
                gameScoreLabel.setText("Score: "+ (gameScore/29));
                root.getChildren().remove(createCoin1());
            }

            if(planeRectangle.getBoundsInParent().intersects(coin2.getBoundsInParent())){
                gameScore = gameScore+1;
                root.getChildren().remove(createCoin2());
                gameScoreLabel.setText("Score: "+ (gameScore/29));
            }

            if(planeRectangle.getBoundsInParent().intersects(coin3.getBoundsInParent())){
                gameScore = gameScore+1;
                root.getChildren().remove(createCoin3());
                gameScoreLabel.setText("Score: "+ (gameScore/29));

            }

            if(planeRectangle.getBoundsInParent().intersects(coin4.getBoundsInParent())){
                gameScore = gameScore+1;
                root.getChildren().remove(createCoin4());
                gameScoreLabel.setText("Score: "+ (gameScore/29));
            }

            if(planeRectangle.getBoundsInParent().intersects(coin5.getBoundsInParent())){
                gameScore = gameScore+1;
                root.getChildren().remove(createCoin5());
                gameScoreLabel.setText("Score: "+ (gameScore/29));
            }
        }
    }

    public Button exitBtn() {
        exitButton.setOnMouseClicked((event)-> Platform.exit());
        return exitButton;
    }

    public void startGame(Scene scene){
        cloudTranslate1.stop();
        cloudTranslate2.stop();
        cloudTranslate3.stop();
        cloudTranslate4.stop();
        cloudTranslate5.stop();

        coinTranslation.stop();
        coinTranslation2.stop();
        coinTranslation3.stop();
        coinTranslation4.stop();
        coinTranslation5.stop();

        planeRectangle.setVisible(false);
        gameScoreLabel.setVisible(false);
        exitButton.setVisible(false);

        gameStatus.setText("Press 'UP' to start the game");
        gameStatus.setFont(new Font("Ubuntu Mono", 50));
        gameStatus.setLayoutY(rootDimHeight/2.5);
        gameStatus.setLayoutX(rootDimWidth/9);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, e ->{
            if (e.getCode() == KeyCode.UP){
                gameStatus.setText("");
                exitButton.setVisible(false);
                planeRectangle.setVisible(true);
                gameScoreLabel.setVisible(true);

                cloudTranslate1.play();
                cloudTranslate2.play();
                cloudTranslate3.play();
                cloudTranslate4.play();
                cloudTranslate5.play();

                coinTranslation.play();
                coinTranslation2.play();
                coinTranslation3.play();
                coinTranslation4.play();
                coinTranslation5.play();

            }
        });

    }



    public static void main(String[] args) {
        launch();
    }
}