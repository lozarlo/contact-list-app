package contacts.model;

import java.sql.*;
import java.util.Vector;

import jakarta.servlet.http.HttpSession;

public class ContactsManager {

	public static Vector<Person> getAll(HttpSession session) {
		Vector<Person> contacts = new Vector<>();
		String sql = "SELECT * FROM lista_contatti";

		try (Connection conn = DatabaseManager.getConnection(session);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Person p = new Person(rs.getString("nome"), rs.getString("cognome"), rs.getString("indirizzo"),
						rs.getString("telefono"), rs.getInt("eta"));
				p.setId(rs.getInt("id"));
				contacts.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	public static void add(Person p, HttpSession session) {
		String sql = "INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DatabaseManager.getConnection(session);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getSurname());
			pstmt.setString(3, p.getAddress());
			pstmt.setString(4, p.getPhone());
			pstmt.setInt(5, p.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Person getById(int id, HttpSession session) {
		String sql = "SELECT * FROM lista_contatti WHERE id = ?";

		try (Connection conn = DatabaseManager.getConnection(session);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Person p = new Person(rs.getString("nome"), rs.getString("cognome"), rs.getString("indirizzo"),
						rs.getString("telefono"), rs.getInt("eta"));
				p.setId(rs.getInt("id"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void update(Person p, HttpSession session) {
		String sql = "UPDATE lista_contatti SET nome=?, cognome=?, indirizzo=?, telefono=?, eta=? WHERE id=?";

		try (Connection conn = DatabaseManager.getConnection(session);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getSurname());
			pstmt.setString(3, p.getAddress());
			pstmt.setString(4, p.getPhone());
			pstmt.setInt(5, p.getAge());
			pstmt.setInt(6, p.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id, HttpSession session) {
		String sql = "DELETE FROM lista_contatti WHERE id = ?";

		try (Connection conn = DatabaseManager.getConnection(session);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}