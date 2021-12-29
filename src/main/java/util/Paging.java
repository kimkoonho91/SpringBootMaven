package util;

public class Paging {
    //선택 페이지, 현재 블록
    private int selectPage, currentBlock;
    
    //페이지 레코드 개수 설정, 블록 개수 설정
    private int pageSize = 10, blockSize = 10;

    //전체 페이지 개수, 전체 블록 개수
    private int totalPageCount, totalBlockCount;
    
    //선택 페이지 레코드 시작 번호, 선택 페이지 레코드 끝 번호
    private int pageStartRecordNum, pageEndRecordNum;

    //선택 페이지 블록 시작 번호, 선택 페이지 블록 끝 번호
    private int blockStartNum, blockEndNum;

    //이전 블록, 다음 블록
    private int prevBlock, nextBlock;

    //작성자
    private String writer;
    
    //전체 데이터 개수
    public void setTotal(int totalDataCount) {
        totalPageCount = (int) Math.ceil(totalDataCount/(double)pageSize);
        totalBlockCount = (int) Math.ceil(totalPageCount/(double)blockSize);
    }   
    
    //페이지 설정
    public void setPage(int selectPage){
        this.selectPage = selectPage;
        
        pageStartRecordNum = (selectPage - 1) * pageSize + 1;
        pageEndRecordNum = pageStartRecordNum + pageSize - 1;
        
        currentBlock = (selectPage-1) / blockSize + 1;
        
        blockStartNum = (currentBlock-1) * blockSize + 1;
        blockEndNum = blockStartNum + blockSize - 1;
        if(blockEndNum > totalPageCount) blockEndNum = totalPageCount;
        
        prevBlock = (selectPage == 1) ? 1 :(currentBlock - 1) * blockSize;
        nextBlock = currentBlock > totalBlockCount ? (currentBlock * blockSize) : (currentBlock * blockSize) + 1;
        if(nextBlock >= totalPageCount) nextBlock = totalPageCount;     
    }
    
    public String toString(String function) {
        String paging = "";
        
        System.out.println("선택 페이지 : " + selectPage);
        System.out.println("현재 블록 : " + currentBlock);
        System.out.println("전체 페이지 개수 : " + totalPageCount);
        System.out.println("전체 블록 개수 : " + totalBlockCount);
        System.out.println("선택 페이지 레코드 시작 번호 : " + pageStartRecordNum);
        System.out.println("선택 페이지 레코드 끝 번호 : " + pageEndRecordNum);
        System.out.println("선택 페이지 블록 시작 번호 : " + blockStartNum);
        System.out.println("선택 페이지 블록 끝 번호 : " + blockEndNum);
        System.out.println("이전 블록 : " + prevBlock);
        System.out.println("다음 블록 : " + nextBlock);
        
        if(blockEndNum > 0){
            //첫 페이지
            if(selectPage != 1){
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(1,\"" + writer + "\")>[처음]</a></span>&nbsp;";
            }else{
                paging += "<span class='pagingStatic pagingMove'>[처음]</span>&nbsp;";
            }
            
            //앞 블록
            if(currentBlock > 1) {
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(" + prevBlock + ",\"" + writer + "\")>[<<]</a></span>&nbsp;";
            }else {
                paging += "<span class='pagingStatic pagingMove'>[<<]</span>&nbsp;";
            }
            
            //앞 장
            if(selectPage != 1) {
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(" + (selectPage-1) + ",\"" + writer + "\")>[<]</a></span>&emsp;";
            }else {
                paging += "<span class='pagingStatic pagingMove'>[<]</span>&emsp;";
            }
            
            //페이지 설정
            for(int number = blockStartNum; number <= blockEndNum; number++){
                if(number == selectPage){
                    paging += "<strong id='currentNumber' class='pagingCurrentNumber'>" + number + "</strong>&emsp;";
                }else{
                    paging += "<span><a href='#' class='pagingNumber' onclick=" + function + "(" + number + ",\"" + writer + "\")>" + number + "</a></span>&emsp;";
                }
            }
            
            //뒷 장
            if(selectPage != totalPageCount){
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(" + (selectPage+1) + ",\"" + writer + "\")>[>]</a></span>&nbsp;";
            }else{
                paging += "<span class='pagingStatic pagingMove'>[>]</span>&nbsp;";
            }
            
            //다음 블록
            if(currentBlock != totalBlockCount) {
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(" + nextBlock + ",\"" + writer + "\")>[>>]</a></span>&nbsp;";
            }else {
                paging += "<span class='pagingStatic pagingMove'>[>>]</span>&nbsp;";
            }
            
            //마지막 페이지
            if(selectPage != totalPageCount){
                paging += "<span><a href='#' class='pagingMove' onclick=" + function + "(" + totalPageCount + ",\"" + writer + "\")>[마지막]</a></span>&nbsp;";
            }else{
                paging += "<span class='pagingStatic pagingMove'>[마지막]</span>&nbsp;";
            }
        }
        
        return paging;
    }

    
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStartRecordNum() {
        return pageStartRecordNum;
    }

    public int getPageEndRecordNum() {
        return pageEndRecordNum;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
