package bean;

public class Result {
    private String region;
    private String name;
    private int total;
    private int count;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Result(String region, String name, int total, int count) {
        this.region = region;
        this.name = name;
        this.total = total;
        this.count = count;
    }
}
