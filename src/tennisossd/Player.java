package tennisossd;

class Player {

    private String name;
    private int setsPlayed, setsWons;

    public Player(String name) {
        this.name = name;
    }

    public void incSetWons() {
        setsWons++;
    }

    public void incSetPlayed() {
        setsPlayed++;
    }

    public String getName() {
        return name;
    }

    public int getSetsPlayed() {
        return setsPlayed;
    }

    public int getSetsWons() {
        return setsWons;
    }

    public void setSetsPlayed(int setsPlayed) {
        this.setsPlayed = setsPlayed;
    }

    public void setSetsWons(int setsWons) {
        this.setsWons = setsWons;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", setsPlayed=" + setsPlayed + ", setsWons=" + setsWons + "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Player) {

            return this.name.equals(((Player) o).getName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
