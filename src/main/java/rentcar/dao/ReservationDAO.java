package rentcar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import rentcar.utli.MybatisConfig;
import rentcar.vo.CarReserveVO;
import rentcar.vo.ReservationViewVO;

public class ReservationDAO {
	private ReservationDAO(){
	}
	static private ReservationDAO instance = new ReservationDAO();
	static public ReservationDAO getInstance() {
		return instance;
	}
	
	public int addReservation(CarReserveVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.insert("reservationInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public ArrayList<ReservationViewVO> getJoinCarView (String id){
		SqlSession session = MybatisConfig.getInstance().openSession();
		List<ReservationViewVO> list = session.selectList("getJoinCarView", id);
		session.close();
		return (ArrayList<ReservationViewVO>)list;
	}
	
	public CarReserveVO getOneReservation(int reserve_req) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		CarReserveVO vo = session.selectOne("getOneReservation", reserve_req);
		session.close();
		return vo;
	}
	
	public int deleteReservation(int reserve_req) {
		SqlSession session = MybatisConfig.getInstance().openSession();
		int cnt = session.delete("Deletereservation", reserve_req);
		session.commit();
		session.close();
		return cnt;
	}
}
