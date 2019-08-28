package com.java.ers.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.java.ers.domain.Reimbursement;
import com.java.ers.utility.ConnectionUtil;
import java.sql.Timestamp;

public class ReimbursementDaoImpl implements ReimbursementDao {

	/**
	 * Function to store new Reimbursement object into the database.
	 * 
	 * @param reimb object going to be stored into database.
	 * @return true if stored, false otherwise
	 */
	@Override
	public boolean insertReimbursement(Reimbursement reimb) {
		boolean result = false;

		// SQL Statement to save the Reimbursement
		String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_ID, REIMB_AMOUNT, "
				+ "REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID"
				+ ") VALUES(?, ?, ?, ?, ?, ?, ?)";

		// Using Prepared Statement.
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, reimb.getId());
			ps.setDouble(2, reimb.getAmount());
			ps.setTimestamp(3, reimb.getSubmitted());
			// ps.setTimestamp(4, reimb.getResolved());
			ps.setString(4, reimb.getDescription());
			ps.setInt(5, reimb.getAuthorId());
			// ps.setInt(7, reimb.getResolverId());
			ps.setInt(6, reimb.getStatusId());
			ps.setInt(7, reimb.getTypeId());

			int inserted = ps.executeUpdate();

			// check if inserted
			result = (inserted > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}

	@Override
	public void delete() {
		// SQL Statement to save the Reimbursement
		String sql = "delete from ERS_REIMBURSEMENT";

		// Using Prepared Statement.
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Function update the status of the Reimbursement Object inside the database.
	 * 
	 * @param id       to identify the reimbursement
	 * @param resId    resolver id
	 * @param statusId to update the status of this reimbursement
	 * @return true if updated, false otherwise
	 */
	public boolean updateStatus(int id, int resId, int statusId) {
		boolean result = false;

		// SQL Statement to save the Reimbursement
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?, REIMB_STATUS_ID=?, "
				+ " REIMB_RESOLVER=? WHERE REIMB_ID=?";

		// Using Prepared Statement.
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			Timestamp submitted = new Timestamp(System.currentTimeMillis());

			ps.setTimestamp(1, submitted);
			ps.setInt(2, statusId);
			ps.setInt(3, resId);
			ps.setInt(4, id);

			int updated = ps.executeUpdate();

			// check if inserted
			result = (updated > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}

	/**
	 * Function to get the collection of all the Reimbursements for a given user
	 * identified by the user id. The user is the one who submitted this
	 * reimbursement.
	 * 
	 * @param userId to identify the user
	 * @return list of all the reimbursements
	 */
	@Override
	public List<Reimbursement> getReimbursementsByUserId(int userId) {
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		List<Reimbursement> all = getAllReimbursements();

		for (Reimbursement re : all) {
			if (re.getAuthorId() == userId) {
				list.add(re);
			}
		}

		return list;
	}

	/**
	 * Function to get the collection of all the Reimbursements stored inside the
	 * database.
	 * 
	 * @return all the reimbursements
	 */
	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		// SQL
		String sql = "SELECT * FROM ERS_REIMBURSEMENT";

		// using Prepared statement
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// Get the result set
			ResultSet rs = ps.executeQuery();

			// Traverse the Result Set
			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorId = rs.getInt("REIMB_AUTHOR");
				int resId = rs.getInt("REIMB_RESOLVER");
				int statusId = rs.getInt("REIMB_STATUS_ID");
				int typeId = rs.getInt("REIMB_TYPE_ID");

				Reimbursement re = new Reimbursement(id, amount, submitted, resolved, description, authorId, resId,
						statusId, typeId);

				list.add(re);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Function to get the List of all the Reimbursements identified by status id.
	 * 
	 * @param statusId to filter the reimbursements
	 * @return list of all the reimbursements of given status.
	 */
	@Override
	public List<Reimbursement> getReimbursementsByStatus(int statusId) {
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		List<Reimbursement> all = getAllReimbursements();

		for (Reimbursement re : all) {
			if (re.getStatusId() == statusId) {
				list.add(re);
			}
		}

		return list;
	}

	@Override
	/**
	 * Function to get the next max Id for Reimbursement table.
	 * 
	 * @return next id
	 */
	public int getNextId() {
		int id = 0;

		// SQL
		String sql = "SELECT max(REIMB_ID) FROM ERS_REIMBURSEMENT";

		// using Prepared statement
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// Get the result set
			ResultSet rs = ps.executeQuery();

			// Traverse the Result Set
			while (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id + 1;
	}

}
