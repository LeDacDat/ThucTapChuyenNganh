package OOP_Collection.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {

	private ArrayList<SinhVien> danhSach;

	public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
		this.danhSach = danhSach;
	}

	public ArrayList<SinhVien> getDanhSach() {
		return danhSach;
	}

	public void setDanhSach(ArrayList<SinhVien> danhSach) {
		this.danhSach = danhSach;
	}
	
	public void themSinhVien(SinhVien sv) {
		this.danhSach.add(sv);
	}

	public DanhSachSinhVien() {
		this.danhSach = new ArrayList<SinhVien>();
	}
	public void inDanhSachSV() {
		for (SinhVien sinhVien : danhSach) {
			System.out.println(sinhVien);
		}
	}
	public boolean kiemTraDSRong() {
		return this.danhSach.isEmpty();
	}
	public int laySoLuongSinhVien() {
		return this.danhSach.size();
	}
	public boolean lamRongDanhSach()
	{
		return this.danhSach.remove(danhSach);
	}
	public boolean kiemTraTonTaiSV(SinhVien sv)
	{
		return this.danhSach.contains(sv);
	}
	public boolean xoaSinhVien(SinhVien sv)
	{
		return this.danhSach.remove(sv);
	}
	public void timSinhVien(String ten)
	{
		for (SinhVien sinhVien : danhSach) {
			if(sinhVien.getTenSinhVien().indexOf(ten)>=0)
				System.out.println(sinhVien);
		}
	}
	
	public void sapXepSVTheoDiem() {
		Collections.sort(this.danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if(o1.getDiemTrungBinh() > o2.getDiemTrungBinh())
					return 1;
				else if(o1.getDiemTrungBinh()<o2.getDiemTrungBinh())
					return -1;
				return 0;
			}
			
		});
	}
	
	
}
