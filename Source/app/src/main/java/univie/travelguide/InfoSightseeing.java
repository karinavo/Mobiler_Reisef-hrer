package univie.travelguide;

import java.util.HashMap;
import java.util.List;

class InfoSightseeing {
    public static String flag_sightseeing = "";

    public static HashMap<String, String> information = new HashMap<String, String>();
    public static HashMap<String,String>  openinghours = new HashMap<String, String>();
    public void addInformation(){
        information.put("Albertina","The Graphic Art Collection of the ALBERTINA Museum offers a truly panoramic survey of art: founded in 1776 by Duke Albert of Saxe-Teschen, this collection now contains over one million drawings and prints from the late Gothic to the present. From Michelangelo and Dürer to Rembrandt and Rubens, and from Klimt and Schiele to Picasso on to Richter and Lassnig, the ALBERTINA Museum’s collection affords a rich overview of 600 years of art history.");
        openinghours.put("Albertina","Daily | 10 a.m. to 6 p.m." +
                    '\n' + "Wednesdays & Fridays | 10 a.m. to 9 p.m.");
        information.put("Belvedere","On 30 November 1697, one year after commencing with the construction of the Stadtpalais, Prince Eugene purchased a sizable plot of land south of the Rennweg, the main road to Hungary. Plans for the Belvedere garden complex were drawn up immediately. The prince chose Johann Lukas von Hildebrandt as the chief architect for this project rather than Johann Bernhard Fischer von Erlach, the creator of his Stadtpalais. Hildebrandt (1668–1745), whom the general had met whilst engaged in a military campaign in Piedmont, had already built Ráckeve Palace for him in 1702 on Csepel, an island in the Danube south of Budapest. He later went on to build numerous other edifices in his service. The architect had studied civil engineering in Rome under Carlo Fontana and had gone into imperial service in 1695–96 in order to learn how to build fortifications. From 1696 onwards, records show that he was employed as a court architect in Vienna. As well as the Belvedere, Hildebrandt’s most outstanding achievements include the Schloss Hof Palace, which was also commissioned by Prince Eugene, the Schwarzenberg Palace (formerly known as the Mansfeld–Fondi Palace), the Kinsky Palace, as well as the entire Göttweig Monastery estate in the Wachau Valley. ");
        information.put("Belvedere","Upper Belvedere\n" +
                "\n" +
                "Prinz Eugen-Straße 27,\n" +
                "1030 Vienna\n" +
                "\t \n" +
                "Daily\t9 am to 6 pm\n" +
                "Friday\t9 am to 9 pm "+
                        "Lower Belvedere and Orangery, PALACE STABLES\n" +
                "\n" +
                "Rennweg 6, 1030 Vienna\n" +
                "\t \n" +
                "Daily\t10 am to 6 pm\n" +
                "Friday\t10 am to 9 pm");
    }

}
