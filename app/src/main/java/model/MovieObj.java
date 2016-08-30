package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmedraza on 29/08/16.
 */
public class MovieObj {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<MovieResults> results;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("total_pages")
    private Integer totalPages;


    public int getPage(){
        return page;
    }
    public void setPage(int page){
        this.page = page;
    }

    public List<MovieResults> getResults(){
        return results;
    }
    public void setResults(List<MovieResults> results){
        this.results = results;
    }

    public Integer getTotalResults(){
        return totalResults;
    }
    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;

    }
    public Integer getTotalPages(){
        return totalPages;
    }
    public void setTotalPages(int totalPages){
        this.totalPages = totalPages;
    }

}
