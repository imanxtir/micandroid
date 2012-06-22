package ningbo.media.data.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "location", propOrder = { "md5Value", "name_cn", "name_en", "address_cn",
		"address_en", "latitude", "longitude","name_py","tags_cn","tags_en" })
@XmlRootElement(name = "data")
public class LocationDetail {

	private String md5Value;

	private String name_cn;

	private String name_en;
	
	private String address_cn;

	private String address_en;

	private Double latitude;

	private Double longitude;
	
	private String name_py ;
	
	private String tags_en ;
	
	private String tags_cn ;

	public LocationDetail() {
	}

	public String getMd5Value() {
		return md5Value;
	}

	public void setMd5Value(String md5Value) {
		this.md5Value = md5Value;
	}

	public String getName_cn() {
		return name_cn;
	}

	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getAddress_cn() {
		return address_cn;
	}

	public void setAddress_cn(String address_cn) {
		this.address_cn = address_cn;
	}

	public String getAddress_en() {
		return address_en;
	}

	public void setAddress_en(String address_en) {
		this.address_en = address_en;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName_py() {
		return name_py;
	}

	public void setName_py(String name_py) {
		this.name_py = name_py;
	}

	public String getTags_en() {
		return tags_en;
	}

	public void setTags_en(String tags_en) {
		this.tags_en = tags_en;
	}

	public String getTags_cn() {
		return tags_cn;
	}

	public void setTags_cn(String tags_cn) {
		this.tags_cn = tags_cn;
	}

	
}
