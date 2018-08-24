package com.board.dao; 
 
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board; 
 
public class BoardDao extends CommonDao { 
	//ibatis 구현 후
	public static BoardDao getInstance() {    // 기존에 구현했던 getInstance메서드
	    BoardDao _instance = new BoardDao();
	    _instance.SetDB();                // 이 코드 한줄이 추가되었습니다.
	    return _instance;
	}  
	
	/*	CommonDao의 GetDB메소드로부터 sqlMap 객체를 가져와서,ibatis를 통해 queryForList()라는 메서드를 사용
		그리고 해당 반환값을 전과 동일하게 (ArrayList<Board>) Board객체형 리스트로 캐스팅 해주고, 해당 리스트(articleList)를 반환	*/
	@SuppressWarnings("unchecked")
	public ArrayList<Board> getArticleList(int page) throws SQLException{
		ArrayList<Board> articleList = null;
		//queryForList("board.xml 즉, xml파일에서 쿼리를 식별하기위해 만들어준 id를 입력",쿼리에 쓰일 파라미터,가져올 페이지번호,가져올 데이터 로우의 갯수)
		//모든 게시글을 가져온뒤에 내부적으로 결과를 잘라서 보여주는 것
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null, page, 10);
		return articleList;
	}
	
	public void insertArticle(Board article) throws SQLException {
		GetDB().insert("insertArticle", article);
	}
	
	public Board getArticle(int idx) throws SQLException {
		Board article = (Board)GetDB().queryForObject("getArticle", idx);
		return article;
	}
	
	public void deleteArticle(int idx) throws SQLException {
		GetDB().delete("deleteArticle", idx);
	}
	
	public void updateArticle(Board article ) throws SQLException {
		GetDB().update("updateArticle", article);
	}
	
	public void updateArticleCount(Board article) throws SQLException {
		GetDB().update("updateArticleCount", article);
	}
	
	/* queryForList 메서드 : 셀렉트 쿼리에 쓰이는 메서드이며 DB에서 조회하는 값이 한개의 행 이상일 경우 사용 
	   queryForObjcet 메서드 : 조회하는 행이 하나일 경우 사용
	update쿼리일 경우에는 update 메서드
	delete쿼리일 경우에는 delete 메서드
	insert쿼리일 경우에는 insert 메서드
	*/

}
	    
	/* ibatis 구현 전
	//싱글턴(Singleton)패턴
	//데이터베이스의 접속이 일어날때마다 Dao객체를 생성하고 연결하는것은 크게 봤을때 상당한 메모리의 낭비
	//최초에 객체를 생성하고 이후 접속요청이 오면 새로운 객체를 생성하지 않고 인스턴스를 반환
	public static BoardDao getInstance() { 
        BoardDao _instance = new BoardDao(); 
        return _instance; 
    }
 
    public ArrayList<Board> getArticleList() throws SQLException { 
        ResultSet rs = null; 
        String sql = "select * from BOARD_test order by idx desc"; 
        rs = openConnection().executeQuery(sql); // sql을 실행하기위해 연결을 열어 쿼리를 실행하고 rs에 반환합니다.
        // 모든 게시글을 가져오기 위한 Board형 배열객체를 선언
        ArrayList<Board> articleList = new ArrayList<Board>();              
 
        while (rs.next()) {
            Board article = new Board();// 데이터들을 담기위해 Board객체에 메모리를 할당                                             
 
            article.setIdx(rs.getInt("idx"));
            article.setTitle(rs.getString("title"));
            article.setWriter(rs.getString("writer"));
            article.setRegdate(rs.getString("regdate"));
            articleList.add(article);// 셋팅된 빈을 리스트에 추가합니다.
        }
        closeConnection(); // 연결을 꼭 닫아줍시다.
 
        return articleList;
    }
    */

