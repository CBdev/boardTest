package com.board.dao; 
 
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board; 
 
public class BoardDao extends CommonDao { 
	//ibatis ���� ��
	public static BoardDao getInstance() {    // ������ �����ߴ� getInstance�޼���
	    BoardDao _instance = new BoardDao();
	    _instance.SetDB();                // �� �ڵ� ������ �߰��Ǿ����ϴ�.
	    return _instance;
	}  
	
	/*	CommonDao�� GetDB�޼ҵ�κ��� sqlMap ��ü�� �����ͼ�,ibatis�� ���� queryForList()��� �޼��带 ���
		�׸��� �ش� ��ȯ���� ���� �����ϰ� (ArrayList<Board>) Board��ü�� ����Ʈ�� ĳ���� ���ְ�, �ش� ����Ʈ(articleList)�� ��ȯ	*/
	@SuppressWarnings("unchecked")
	public ArrayList<Board> getArticleList(int page) throws SQLException{
		ArrayList<Board> articleList = null;
		//queryForList("board.xml ��, xml���Ͽ��� ������ �ĺ��ϱ����� ������� id�� �Է�",������ ���� �Ķ����,������ ��������ȣ,������ ������ �ο��� ����)
		//��� �Խñ��� �����µڿ� ���������� ����� �߶� �����ִ� ��
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
	
	/* queryForList �޼��� : ����Ʈ ������ ���̴� �޼����̸� DB���� ��ȸ�ϴ� ���� �Ѱ��� �� �̻��� ��� ��� 
	   queryForObjcet �޼��� : ��ȸ�ϴ� ���� �ϳ��� ��� ���
	update������ ��쿡�� update �޼���
	delete������ ��쿡�� delete �޼���
	insert������ ��쿡�� insert �޼���
	*/

}
	    
	/* ibatis ���� ��
	//�̱���(Singleton)����
	//�����ͺ��̽��� ������ �Ͼ������ Dao��ü�� �����ϰ� �����ϴ°��� ũ�� ������ ����� �޸��� ����
	//���ʿ� ��ü�� �����ϰ� ���� ���ӿ�û�� ���� ���ο� ��ü�� �������� �ʰ� �ν��Ͻ��� ��ȯ
	public static BoardDao getInstance() { 
        BoardDao _instance = new BoardDao(); 
        return _instance; 
    }
 
    public ArrayList<Board> getArticleList() throws SQLException { 
        ResultSet rs = null; 
        String sql = "select * from BOARD_test order by idx desc"; 
        rs = openConnection().executeQuery(sql); // sql�� �����ϱ����� ������ ���� ������ �����ϰ� rs�� ��ȯ�մϴ�.
        // ��� �Խñ��� �������� ���� Board�� �迭��ü�� ����
        ArrayList<Board> articleList = new ArrayList<Board>();              
 
        while (rs.next()) {
            Board article = new Board();// �����͵��� ������� Board��ü�� �޸𸮸� �Ҵ�                                             
 
            article.setIdx(rs.getInt("idx"));
            article.setTitle(rs.getString("title"));
            article.setWriter(rs.getString("writer"));
            article.setRegdate(rs.getString("regdate"));
            articleList.add(article);// ���õ� ���� ����Ʈ�� �߰��մϴ�.
        }
        closeConnection(); // ������ �� �ݾ��ݽô�.
 
        return articleList;
    }
    */

