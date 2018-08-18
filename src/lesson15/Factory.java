package lesson15;

public class Factory {

    public static void getRandomfactoryDetail() {
        for (int i = 0; i < Util.getRandom(Util.MIN, Util.MAX); i++) {
            Details detail = Details.getRandomDetail();
            Util.putInStorage(Dump.dump, detail);
        }
    }
}