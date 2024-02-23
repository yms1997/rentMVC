package rentcar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import rentcar.utli.MybatisConfig;
import rentcar.vo.MemberVO;

public class MemberDAO {
	private MemberDAO() {
	}
	static private MemberDAO instance = new MemberDAO();
	
	static public MemberDAO getInstance() {
		return instance;
	}
	
	public String checkLogin(String id, String pw) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		
		SqlSession session = MybatisConfig.getInstance().openSession();
		String check = session.selectOne("checkLogin", vo);
		session.close();
		return check;
	}
	
	public int getMemberNo(String id) {
    	SqlSession session = MybatisConfig.getInstance().openSession();
    	int num = session.selectOne("getMemberNo", id);
    	session.close();
        return num;
    }
	
	public int memberInsert(MemberVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public ArrayList<MemberVO> memberList(){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<MemberVO> list = session.selectList("memberList");
		session.close();
		return (ArrayList<MemberVO>)list;
	}
	
	public MemberVO memberContent(int no) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		MemberVO vo = session.selectOne("memberContent", no);
		session.close();
		return vo;
	}
	
	public int memberDelete(String id) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.delete("memberDelete", id);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int memberUpdate(MemberVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.update("memberUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}
}
