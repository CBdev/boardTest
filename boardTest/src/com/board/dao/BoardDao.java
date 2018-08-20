package com.board.dao; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import com.board.beans.Board; 
 
public class BoardDao extends CommonDao { 
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
}

