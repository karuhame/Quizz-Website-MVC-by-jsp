package Model.bo;

import Model.dao.AccountDAO;

import java.util.List;

import Model.bean.*;

public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	// Get role
	// Get ID
	public int checkLoginAndGetID(String username, String password) {
		
		return accountDAO.checkLogin(username, password);
	}
	
	public int getRoleByID(int ID) {
		return accountDAO.getRoleByID(ID);
	}

	public void Logout() {
		accountDAO.Logout();
	}
	
	public void updatePassword(int ID_Account, String newPass) {
		accountDAO.updatePassword(ID_Account, newPass);
	}
	
	public List<AccountBEAN> getAllAccount(){
		return accountDAO.getAllAccount();
		
	}
}
//
//public class KhachHangBO {
//	KhachHangDAO khachHangDAO = new KhachHangDAO();
//	
//	
//	public List<String> getBillByMaKH(String MaKH) {
//		List<String> list = new ArrayList<>();
//		int sumBill = 0;
////		Get all Lich Su Tiem Phong
//		LichSuTiemPhongDAO lichSuTiemPhongDAO = new LichSuTiemPhongDAO();
//		VacxinDAO vacxinDAO = new VacxinDAO();
//		List<LichSuTiemPhongBEAN> tiemphong_list = lichSuTiemPhongDAO.getAllLichSuTiemPhongByMaKH(MaKH);
//		
//		
//		for(LichSuTiemPhongBEAN lichsu: tiemphong_list) {
//			String maVacxin = lichsu.MaVacxin;
//			int giaVacxin = vacxinDAO.getGiaVacxinByMaVacxin(maVacxin);
//			sumBill += giaVacxin;
//		}
//		
//		KhachHangBEAN kh = khachHangDAO.getKhachHangByMaKH(MaKH);
//		list.add(kh.MaKH);
//		list.add(kh.HoTenKH);
//		list.add(kh.DiaChiKH);
//		list.add(String.valueOf(sumBill));
//		
//// 		Get GiaVacxinByMaVacxin
//		return list;
//	}
//	
//	public ArrayList<List<String>> getAllBill(){
//		List<KhachHangBEAN> list = this.getAllKhachHang();
//		ArrayList<List<String>> res = null;
//		for(KhachHangBEAN kh: list) {
//			List<String> info = this.getBillByMaKH(kh.MaKH);
//			res.add(info);
//		}
//		return res;
//	}
//	public List<String> getLichSuByMaKH(String MaKH){
//		List<String> list = new ArrayList();
//		LichSuTiemPhongDAO lichSuTiemPhongDAO = new LichSuTiemPhongDAO();
//		VacxinDAO vacxinDAO = new VacxinDAO();
//		System.out.println(MaKH);
//		List<LichSuTiemPhongBEAN> tiemphong_list = lichSuTiemPhongDAO.getAllLichSuTiemPhongByMaKH(MaKH);
//		
//		BenhDAO benhDAO = new BenhDAO();
//		KhachHangBEAN kh = khachHangDAO.getKhachHangByMaKH(MaKH);
//		list.add(kh.MaKH);
//		list.add(kh.HoTenKH);
//		for(LichSuTiemPhongBEAN lichsu: tiemphong_list) {
//			String maVacxin = lichsu.MaVacxin;
//			VacxinBEAN vacxin = vacxinDAO.getVacxinByMaVacxin(maVacxin);
//			String tenBenh = benhDAO.getTenBenhByMaVacxin(vacxin.MaVacxin);
//			list.add(tenBenh);
//			list.add(vacxin.MaVacxin);
//			list.add(vacxin.TenVacxin);
//			list.add(String.valueOf(vacxin.SoMui));
//		}
//		return list;
//		
//	}
//
//	public List<KhachHangBEAN> getAllKhachHang() {
//		// TODO Auto-generated method stub
//		return khachHangDAO.getAllKhachHang();
//	}
//}
