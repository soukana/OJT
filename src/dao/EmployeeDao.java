package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employee.Employee;

public class EmployeeDao {

	Statement stmt;
	Connection con;

	public void connect() {

		try {

			Class.forName("org.postgresql.Driver"); // ドライバクラスをロード
			// JDBCドライバの登録
			String driver = "org.postgresql.Driver";
			// データベースの指定
			String server = "localhost"; // PostgreSQL サーバ ( IP または ホスト名 )
			String defaultdbname = "postgres"; // デフォルトで存在するデータベース名
			String defaulturl = "jdbc:postgresql://" + server + "/" + defaultdbname;

			// String databaseName = "testdb"; // 今後データの書き込みに使用するデータベース名
			// String databaseurl = "jdbc:postgresql://" + server + "/" +
			// databaseName;

			String user = "postgres"; // データベース作成ユーザ名
			String password = ""; // データベース作成ユーザパスワード
			Class.forName(driver);

			// データベースとの接続
			con = DriverManager.getConnection(defaulturl, user, password);
			// データベースへ接続
			stmt = con.createStatement();
		} catch (

		Exception e)

		{
			e.printStackTrace();
		}
	}

	public void close() {
		// データベースから切断
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployee() {
		connect();

		List<Employee> eList = new ArrayList<Employee>();

		try {

			String sql = "SELECT * FROM employee"; // SQL文を指定
			// クエリーを実行して結果セットを取得
			ResultSet rs = stmt.executeQuery(sql);
			// 検索された行数分ループ
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id")); // classを取得
				emp.setName(rs.getString("name")); // nameを取得
				emp.setAge(rs.getInt("age")); // clubを取得
				emp.setAddress(rs.getString("address")); // addressを取得
				eList.add(emp);
			}
			close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}
