public class Option {

    private String option;
    private String linkPath;
    private String ifConditions;
    private String ifNotConditions;

    public Option(String option, String linkPath, String ifConditions, String ifNotConditions) {
        this.option = option;
        this.linkPath = linkPath;
        this.ifConditions = ifConditions;
        this.ifNotConditions = ifNotConditions;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getIfConditions() {
        return ifConditions;
    }

    public void setIfConditions(String ifConditions) {
        this.ifConditions = ifConditions;
    }

    public String getIfNotConditions() {
        return ifNotConditions;
    }

    public void setIfNotConditions(String ifNotConditions) {
        this.ifNotConditions = ifNotConditions;
    }
}
