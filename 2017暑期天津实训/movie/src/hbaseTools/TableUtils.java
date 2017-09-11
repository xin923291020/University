package hbaseTools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TableUtils
{
	public static void insertInToMovie(Table table, String jsonString) throws IOException
	{
		String output = "";
		JSONObject jsonObject = JSON.parseObject(jsonString);
		String id = jsonObject.getString("id");
		output += "put 'MOVIE','" + id + "','info:id','" + id + "'\r\n";
		String original_title = jsonObject.getString("original_title");
		String[] temp = original_title.split("'");
		original_title = "";
		for(int i = 0; i < temp.length;i++)
		{
			if(i == temp.length - 1)
			{
				original_title += temp[i];
				break;
			}
			original_title += temp[i] + "\\'";
		}
		output += "put 'MOVIE','" + id + "','info:original_title','" + original_title + "'\r\n";
		String overview = jsonObject.getString("overview");
		temp = overview.split("'");
		overview = "";
		for(int i = 0; i < temp.length;i++)
		{
			if(i == temp.length - 1)
			{
				overview += temp[i];
				break;
			}
			overview += temp[i] + "\\'";
		}
		output += "put 'MOVIE','" + id + "','info:overview','" + overview + "'\r\n";
		String poster_path = jsonObject.getString("poster_path");
		output += "put 'MOVIE','" + id + "','info:poster_path','" + poster_path + "'\r\n";
		String release_date = jsonObject.getString("release_date");
		output += "put 'MOVIE','" + id + "','info:release_date','" + release_date + "'\r\n";
		String vote_count = jsonObject.getString("vote_count");
		output += "put 'MOVIE','" + id + "','info:vote_count','" + vote_count + "'\r\n";
		String runtime = jsonObject.getString("runtime");
		output += "put 'MOVIE','" + id + "','info:runtime','" + runtime + "'\r\n";
		String popularity = jsonObject.getString("popularity");
		output += "put 'MOVIE','" + id + "','info:popularity','" + popularity + "'\r\n";
		String genres = jsonObject.getString("genres");
		output += "put 'MOVIE','" + id + "','info:genres','" + genres + "'\r\n";
		FileWriter fw = null;
		try
		{
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("D:\\movie.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(output);
		pw.flush();
		try
		{
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 设置行键
		/*Put put = new Put(Bytes.toBytes(id));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("id"), Bytes.toBytes(id));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("original_title"), Bytes.toBytes(original_title));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("overview"), Bytes.toBytes(overview));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("poster_path"), Bytes.toBytes(poster_path));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("release_date"), Bytes.toBytes(release_date));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("vote_count"), Bytes.toBytes(vote_count));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("runtime"), Bytes.toBytes(runtime));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("popularity"), Bytes.toBytes(popularity));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("genres"), Bytes.toBytes(genres));
		table.put(put);*/
	}

	public static void insertInToGenre(Table table, String jsonString)
	{
		JSONObject jsonObject = JSON.parseObject(jsonString);
		String cid = jsonObject.getString("cid");
		String id = jsonObject.getString("id");
		String name = jsonObject.getString("name");
		String output = "";
		String rowKey = new String(cid + id);
		Put put = new Put(Bytes.toBytes(cid + id));
		put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("cid"), Bytes.toBytes(cid));
		output += "put 'GENRE','" + rowKey + "','info:cid','" + cid + "'\r\n";
		put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("id"), Bytes.toBytes(id));
		output += "put 'GENRE','" + rowKey + "','info:id','" + id + "'\r\n";
		put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("name"), Bytes.toBytes(name));
		output += "put 'GENRE','" + rowKey + "','info:name','" + name + "'\r\n";
		FileWriter fw = null;
		try
		{
			table.put(put);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("D:\\genre.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(output);
		pw.flush();
		try
		{
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void insertInToCustomerGenres(String jsonString)
	{
		JSONObject jsonObject = JSON.parseObject(jsonString);
		String id = jsonObject.getString("id");
		String genres = jsonObject.getString("genres");
		String output = "";
		output += "put 'CustomerGenres','" + id + "','info:genres','" + genres + "'\r\n";
		FileWriter fw = null;
		try
		{
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("D:\\customerGenres.txt");
			fw = new FileWriter(f, true);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(output);
		pw.flush();
		try
		{
			fw.flush();
			pw.close();
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void insertInToCustomerGenreMovie(String jsonString)
	{
		JSONObject jsonObject = JSON.parseObject(jsonString);
		String id = jsonObject.getString("id");
		String genreId = jsonObject.getString("genreId");
		String movieId = jsonObject.getString("movieId");
		String rowKey = id + "-" + genreId + "-" + movieId;
		String output = "";
		output += "put 'CustomerGenreMovie','" + rowKey + "','id:id','" + id + "'\r\n";
		output += "put 'CustomerGenreMovie','" + rowKey + "','id:genreId','" + genreId + "'\r\n";
		output += "put 'CustomerGenreMovie','" + rowKey + "','id:movieId','" + movieId + "'\r\n";
		
		FileWriter fw = null;
		try
		{
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("D:\\customerGenreMovie.txt");
			fw = new FileWriter(f, true);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(output);
		pw.flush();
		try
		{
			fw.flush();
			pw.close();
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}