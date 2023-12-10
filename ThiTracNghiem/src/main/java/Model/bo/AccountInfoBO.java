package Model.bo;

import java.util.List;

import Model.bean.AccountBEAN;
import Model.bean.AccountInfoBEAN;

import Model.dao.AccountInfoDAO;

public class AccountInfoBO {
	AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
	// Get role
	// Get ID
	public List<AccountInfoBEAN> getAllStudentInfo(){
		return accountInfoDAO.getAllStudentInfo();
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
