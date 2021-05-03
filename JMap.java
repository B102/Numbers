package numbers;

class JMap {
    private JMapCell[][] mapInfo;
    void load(JMapCell[][] map){
        mapInfo = map;
        System.out.println("Map loaded");
    }
}
