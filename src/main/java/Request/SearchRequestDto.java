package Request;

public class SearchRequestDto {
    private String paramForSearch;
    private String value;

    // Getters and Setters
    public String getParamForSearch() {
        return paramForSearch;
    }

    public void setParamForSearch(String paramForSearch) {
        this.paramForSearch = paramForSearch;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}