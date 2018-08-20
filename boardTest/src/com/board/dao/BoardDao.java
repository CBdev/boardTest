package com.board.dao; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import com.board.beans.Board; 
 
public class BoardDao extends CommonDao { 
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
}

