package rentcar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import rentcar.utli.MybatisConfig;
import rentcar.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {
	}
	static private BoardDAO instance = new BoardDAO();
	
	static public BoardDAO getInstance() {
		return instance;
	}
	
	public ArrayList<BoardVO> boardList(){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<BoardVO> list = session.selectList("boardList");
		session.close();
		return (ArrayList<BoardVO>)list;
	}
	
	public int countboardList() {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.selectOne("countboardList");
		session.close();
		return cnt;
	}
}
