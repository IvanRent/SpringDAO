package org.dao.sregion;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.modelo.sregion.Region_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl {
	@Autowired
	
	private DataSource dataSource;
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	//Asigna la conexión al template
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	//Queries: insert, update, delete
	public void insert(Region_2 reg)
	{
		String sql = "INSERT INTO Region_2 (id,nombre) VALUES (?,?)";
		template.update(sql, new Object[]{reg.getId(), reg.getNombre()});
	}
	public void update(Region_2 reg)
	{
		String sql = "UPDATE Region_2 SET nombre = ? where id = ?";
		template.update(sql, new Object[]{ reg.getNombre(), reg.getId()});
	}
	public void delete(Region_2 reg)
	{
		String sql = "DELETE FROM Region_2 WHERE ID = ?";
		template.update(sql, new Object[]{reg.getId()});
	}
	
	//Queries: select all, select by id
	public static final class Region_2Mapper implements RowMapper<Region_2>
	{
		@Override
		public Region_2 mapRow(ResultSet rs, int row) throws SQLException {
		Region_2 region = new Region_2();
		region.setId(rs.getInt("id"));
		region.setNombre(rs.getString("nombre"));
			return region;
		}
		
	
	}
	public List<Region_2> selectAll(){
		String sql =  "select * from region_2";
		return template.query(sql, new Region_2Mapper());
	}
	public Region_2 selectById(int id)
	{
		String sql = "select * from region_2 where id = ?";
		return template.queryForObject(sql, new Object[]{id}, new Region_2Mapper());
	}
	
	public void createTableNota()
	{
		String sql ="CREATE TABLE NOTA("
				+ "ID 	NUMBER(10) NOT NULL,"
				+"TIPO  VARCHAR(25) NOT NULL,"
				+"COMENTARIO VARCHAR(50) NOT NULL,"
				+"FECHA DATE,"
				+"CONSTRAINT NOTA_PK PRIMARY KEY(ID))";
		template.execute(sql);
	}
}