package OOP_Collection.model.test;

import java.util.Scanner;

import OOP_Collection.model.Xe;

public class XeDeMo {
	
	static Xe dsXe[];
	static int n;
	
	static void Nhap() {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Nhap vao so luong xe:");
		n = sc.nextInt();
		sc.nextLine();
		
		dsXe = new Xe[n];
		for(int i =0;i<n;i++)
		{
			dsXe[i] = new Xe();
			dsXe[i].Nhap();
		}
		
		
	}
	static void inDSXe() {
		Xe.xuatTieuDe();
		for (Xe xe : dsXe) {
			xe.xuatDL();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		do {
			System.out.println("1.Nhap thong tin xe");
			System.out.println("2.Xuat thong tin xe");
			System.out.println("3.Thoat");
			System.out.println("Lua chon cua ban la?");
			
			chon = sc.nextInt();
			
			switch(chon)
			{
			case 1:
				Nhap();
				break;
			case 2:
				inDSXe();
				break;
			case 3:
				System.exit(0);
			}
			
		}while(chon!=0);
		
	}

}
