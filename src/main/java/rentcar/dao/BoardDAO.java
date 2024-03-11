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
	
	public BoardVO boardContent(int no) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		BoardVO vo = session.selectOne("boardContent", no);
		session.close();
		return vo;
	}
	
	public int boardUpdate(BoardVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.update("updateboardContent", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int boardDelete(int no) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.delete("boardDelete", no);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int boardInsert(BoardVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.insert("boardInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int boardUpdateReadCnt(int no) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.update("updateRead_cnt", no);
		session.commit();
		session.close();
		return cnt;
	}
}
