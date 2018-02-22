package com.Myweb.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Myweb.Entity.FileRowMapper;
import com.Myweb.Entity.FileType;
import com.Myweb.Entity.FileTypeRowMapper;
import com.Myweb.Entity.UpFile;
import com.Myweb.Entity.User;
import com.Myweb.Entity.UserRowMapper;

public class FileService extends BaseService {
	/***
	 * 获取文件的类别
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public List<FileType> getALLtype() throws DataAccessException {
		String sql = "select * from t_type where type_isvalid=1";
		return this.jdbcTemplate.query(sql, new FileTypeRowMapper());
	}

	/***
	 * 根据文件的类型获取相应的文件
	 * 
	 * @param filetypeid
	 * @return
	 */

	public List<UpFile> getFileByLb(int filetypeid) {

		String sql = "select * from t_file where file_typeid=?";

		return this.jdbcTemplate.query(sql, new FileRowMapper(), filetypeid);
	}

	// 获取所有上传文件信息
	public List<UpFile> getAllFile(String userid) {
		String sql = "select * from t_file where user_id=?";
		List<UpFile> list = this.jdbcTemplate.query(sql, new FileRowMapper(),userid);
		return list;

	}

	// 根据文件名或上传时间进行模糊查询点名数据
	public List<UpFile> getFileBytn(String key) {
		key = "%" + key + "%";
		String sql = "select * from t_file where file_time like ? or file_name like ?";
		List<UpFile> list = this.jdbcTemplate.query(sql, new FileRowMapper(),
				key, key);
		return list;

	}

	/***
	 * 上传文件
	 * 
	 * @param fileid
	 * @param userid
	 * @param filename
	 * @param filetime
	 * @param filesize
	 * @param filepath
	 */
	public void addFile(String fileid, String userid, String filename,
			String filetime, String filesize, String filepath, int filetypeid) {
		String sql = "insert into t_file(file_id,user_id,file_name,file_time,file_size,file_path,file_typeid)values(?,?,?,?,?,?,?)";

		this.jdbcTemplate.update(sql, fileid, userid, filename, filetime,
				filesize, filepath, filetypeid);

	}

	/***
	 * 根据文件id查找文件
	 * 
	 * @param fileid
	 * @return
	 */
	public UpFile getFileById(String fileid) {

		String sql = "select * from t_file where file_id=?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new FileRowMapper(),
					fileid);
		} catch (DataAccessException e) {
			return null;
		}
	}

}
