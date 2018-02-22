package com.mscreen.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.mscreen.bean.Equipment;
import com.mscreen.bean.User;
@Service
public class UserDao extends BaseDao{

	public User getuser(String userid)//获取用户
	{
		return (User)this.getSqlMapClientTemplate().queryForObject("user.getuser",userid);
	}
	
	public String isExist_hashcode(String hashcode)//判断用户是否存在
	{
		return (String)this.getSqlMapClientTemplate().queryForObject("user.isExist_hashcode",hashcode);
	}
	public void user_changestate(HashMap<String , String> map)
	{
		this.getSqlMapClientTemplate().update("user.user_changestate",map);
	}
	
	public String registerdao(User user)//注册
	{
		this.getSqlMapClientTemplate().insert("user.register", user);
		return (String)user_isExist(user.getuserId());
	}
	public String user_isExist(String userid)//判断用户是否存在,返回可用状态
	{
		return (String)this.getSqlMapClientTemplate().queryForObject("user.user_isExist",userid);
	}
	
	public String login(String userid)//登陆返回pwd,必须返回pwd用于protocol验证
	{
		return (String)this.getSqlMapClientTemplate().queryForObject("user.login",userid);
	}
	public String bdequipment(String userid,String equipmentid,String pwd,String equipmentname)//���豸
	{
		//System.out.println(userid+"������豸"+equipmentid+"-"+pwd+"-"+equipmentname);
		String ip=equipment_isExist(equipmentid);
		if(ip!=null&&ip!="")
		{
			if(equipment_isbd(userid, equipmentid)==null)
			{
				HashMap< String, String> map=new HashMap<String, String>();
				map.put("equipmentid",equipmentid );
				map.put("pwd", pwd);
				String ischeck=(String)this.getSqlMapClientTemplate().queryForObject("user.checkequipment",map);
				if(ischeck!=null&&ischeck!="")
				{
					map.put("userid",userid);
					map.put("equipmentname", equipmentname);
					map.put("ip" ,ip);
					this.getSqlMapClientTemplate().insert("user.bdequipment",map);
					if(equipment_isbd(userid, equipmentid)!=null)
					{
						return "111";//�󶨳ɹ�
					}
					else return "101";//��ʧ�ܣ�δ֪ԭ��
				}
				else 
					return "000";//�������
			}
			else return "110";//�Ѱ�
		}
		else 
			return "100";//������
	}
	
	public String equipment_isExist(String equipmentid)//�豸�Ƿ����/�����豸ipȷ���Ƿ����
	{
		return (String)this.getSqlMapClientTemplate().queryForObject("user.equipment_isExist",equipmentid);
	}

	public Equipment equipment_isbd(String userid,String equipmentid)//�ж��豸�Ƿ��Ѱ�
	{
		HashMap<String , String> map =new HashMap<String, String>();
		map.put("userid", userid);
		map.put("equipmentid", equipmentid);
		return (Equipment)this.getSqlMapClientTemplate().queryForObject("user.equipment_isbd",map);
	}
	
	public ArrayList<Equipment> getEquipment(String userid)//��ȡ�豸�б�
	{
		return (ArrayList<Equipment>)this.getSqlMapClientTemplate().queryForList("user.getequipment",userid);
		
		//equipment.getIp((String)this.getSqlMapClientTemplate().qu)
	}
	public void updataip(String equipmentid,String ip)//�����豸ip
	{
		HashMap<String, String >map=new HashMap<String, String>();
		map.put("equipmentid", equipmentid);
		map.put("ip", ip);
		this.getSqlMapClientTemplate().update("user.upequipmentip",map);
		this.getSqlMapClientTemplate().update("user.upequipmentip1",map);
	}
	public String  addequipment(String equipmentid,String pwd,String ip)//����豸
	{
		HashMap<String, String >map=new HashMap<String, String>();
		map.put("equipmentid", equipmentid);
		map.put("pwd", pwd);
		map.put("ip", ip);
		if(equipment_isExist(equipmentid)==null)
		{this.getSqlMapClientTemplate().insert("user.addequipment",map);return "111";}//��ӳɹ�
		else {
			return "100";
		}
	}
	/*public String user_isExist(String userid)//�����û��Ƿ����
	{
		return (String)this.getSqlMapClientTemplate().queryForObject("user.user_isExist",userid);

	}


	@SuppressWarnings("unchecked")
	public List<User> getuser_nsrsbh (String userid)
	{
		return (List<User>)this.getSqlMapClientTemplate().queryForList("user.getuser_nsrsbh",userid);
	}
	public String addnsrsbh(String userid,String nsrsbh,String nsrmc,String shzt,String sqrq)
	{
		Map<String,String> map=new HashMap<String ,String>();
		map.put("userid", userid);
		map.put("nsrsbh", nsrsbh);
		map.put("nsrmc", nsrmc);
		map.put("shzt", shzt);
		map.put("sqrq", sqrq);
		this.getSqlMapClientTemplate().insert("user.addnsrsbh",map);
		return isExist(userid,nsrsbh);
	}
	public String isExist(String userid,String nsrsbh)//�ж��Ƿ��Ѱ�
	{
		Map<String,String> map1=new HashMap<String ,String>();
		map1.put("userid", userid);
		map1.put("nsrsbh", nsrsbh);
		return (String)this.getSqlMapClientTemplate().queryForObject("user.user_nsrsbh_exist",map1);
	}
	public String bd_changestate(String userid,String nsrsbh,String shzt,String tgrq)//�޸����״̬
	{
		Map<String,String> map=new HashMap<String ,String>();
		map.put("userid", userid);
		map.put("nsrsbh", nsrsbh);
		map.put("shzt", shzt);
		map.put("tgrq", tgrq);
		this.getSqlMapClientTemplate().update("user.bd_changestate",map);
		return bd_checkstate(userid,nsrsbh);
	}
	public String bd_checkstate(String userid,String nsrsbh)//�鿴���״̬
	{
		Map<String,String> map1=new HashMap<String ,String>();
		map1.put("userid", userid);
		map1.put("nsrsbh", nsrsbh);
		return	(String)this.getSqlMapClientTemplate().queryForObject("user.bd_checkstate",map1);
	}
	public String user_changestate(String userid,String shzt)//�޸��û����״̬
	{
		Map<String,String> map=new HashMap<String ,String>();
		map.put("userid", userid);
		map.put("shzt", shzt);
		this.getSqlMapClientTemplate().update("user.user_changestate",map);
		return user_checkstate(userid);
	}
	public String user_checkstate(String userid)//�鿴���״̬
	{
		Map<String,String> map1=new HashMap<String ,String>();
		map1.put("userid", userid);
		return	(String)this.getSqlMapClientTemplate().queryForObject("user.user_checkstate",map1);
	}*/
}
