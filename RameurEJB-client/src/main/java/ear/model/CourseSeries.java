package ear.model;

import ear.entity.Mesure;
import ear.entity.Utilisateur;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CourseSeries extends Course {
    private int nbCoups;
    private boolean toFinish = false;

    public CourseSeries(ear.entity.Course courseData, String queu, String topic, Utilisateur usr, int nbCoups) {
        super(courseData, queu, topic, usr);
        this.nbCoups = nbCoups;
    }

    @Override
    public void lancerCourseVShumain() throws IOException, TimeoutException, InterruptedException {
        String routingKey = "course."+this.courseData.getId()+".#";

        this.rl.goToMenu();
        while (!toFinish) {
            //MESURE AVEC RAMEUR
            Mesure mesure = this.rl.getMesure(this.utilisateur.getIdentifiant(),this.courseData.getId());

            //MESURE ALEATOIRE
            //Mesure mesure = this.mesureAleatoire(this.utilisateur.getIdentifiant(),this.courseData.getId(),null);
            System.out.println(mesure.toString());
            this.senderData.send_mesure(mesure);

            this.senderTopic.send_mesure(mesure,routingKey);
            this.consumerTopic.getMessage();
            toFinish= (this.nbCoups <= mesure.getNbCoup());
            Thread.sleep(500);
        }
        this.rl.goToMenu();
    }
}
