package ua.lviv.iot.tripadvisor.dal;

import java.util.List;

public interface FileRepository {
	public List<String[]> readAll(String filepath);

	public void writeAll(String filepath, List<String[]> data);
}
