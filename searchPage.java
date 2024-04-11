public class SearchPage {
    private BookSearchStrategy searchStrategy;
    //search book
    public void setSearchStrategy(BookSearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }
    public void searchBook(String keyword){
        searchStrategy.search(keyword);
    }

}
