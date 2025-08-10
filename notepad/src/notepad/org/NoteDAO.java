package notepad.org;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    public boolean addNote(Note note) {
        String sql = "INSERT INTO notes (title, content, category, tags) VALUES (?, ?, ?, ?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.setString(3, note.getCategory());
            ps.setString(4, note.getTags());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Note> getAllNotes() {
        List<Note> list = new ArrayList<>();
        String sql = "SELECT * FROM notes ORDER BY created_at DESC";

        try (Connection con = DBconnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Note note = new Note(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("category"),
                    rs.getString("tags"),
                    rs.getString("created_at")
                );
                list.add(note);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateNote(Note note) {
        String sql = "UPDATE notes SET title=?, content=?, category=?, tags=? WHERE id=?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.setString(3, note.getCategory());
            ps.setString(4, note.getTags());
            ps.setInt(5, note.getId());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNote(int id) {
        String sql = "DELETE FROM notes WHERE id=?";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Note getNoteById(int id) {
        String sql = "SELECT * FROM notes WHERE id=?";
        Note note = null;

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                note = new Note(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("category"),
                    rs.getString("tags"),
                    rs.getString("created_at")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return note;
    }
}