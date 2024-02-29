package rentcar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import rentcar.utli.MybatisConfig;
import rentcar.vo.CarReserveVO;
import rentcar.vo.RentcarVO;

public class RentcarDAO {
	private RentcarDAO(){
	}
	static private RentcarDAO instance = new RentcarDAO();
	static public RentcarDAO getInstance() {
		return instance;
	}
	
	public ArrayList<RentcarVO> getAllCarlist(){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<RentcarVO> list = session.selectList("getAllRentcar");
		session.close();
		return (ArrayList<RentcarVO>)list;
	}
	
	public ArrayList<RentcarVO> getRecentCarlist(){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<RentcarVO> list = session.selectList("getRecentCarList");
		session.close();
		return (ArrayList<RentcarVO>)list;
	}
	
	public ArrayList<RentcarVO> getKindCarlist(int category){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<RentcarVO> list = session.selectList("getKindCarList", category);
		session.close();
		return (ArrayList<RentcarVO>)list;
	}
	
	public RentcarVO getOneCar(int no) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		RentcarVO vo = session.selectOne("getOneRentCar", no);
		session.close();
		return vo;
	}
	
	public int reduceTotalQty(CarReserveVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.update("reduceTotalQty", vo);
		session.commit();
		session.close();
		return cnt;
	}
}
