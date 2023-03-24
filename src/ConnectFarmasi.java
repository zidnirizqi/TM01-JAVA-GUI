import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConnectFarmasi {
    public static int jumlahdata;
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        assert response !=null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<modelfarmasi> modelfarmasis =
                new ArrayList<>();
        for (int i=0;i<responseJSON.length();i++){
             modelfarmasi resModel= new modelfarmasi();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setI_code(myJSONObject.getString("i_code"));
            resModel.setG_code(myJSONObject.getString("g_code"));
            resModel.setI_barcode(myJSONObject.getString("i_barcode"));
            resModel.setI_brands(myJSONObject.getString("i_brands"));
            resModel.setI_cogs(myJSONObject.getString("i_cogs"));
            resModel.setI_color(myJSONObject.getString("i_color"));
            resModel.setI_kdsell(myJSONObject.getString("i_kdsell"));
            resModel.setI_qty(myJSONObject.getString("i_qty"));
            resModel.setI_qtymin(myJSONObject.getString("i_qtymin"));
            resModel.setI_supp(myJSONObject.getString("i_supp"));
            resModel.setI_sell(myJSONObject.getString("i_sell"));
            resModel.setI_name(myJSONObject.getString("i_name"));
            resModel.setI_unit(myJSONObject.getString("i_unit"));
            resModel.setI_size(myJSONObject.getString("i_size"));
            resModel.setI_article(myJSONObject.getString("i_article"));
            resModel.setI_status(myJSONObject.getString("i_status"));
            resModel.setId(myJSONObject.getString("id"));
            modelfarmasis.add(resModel);
        }
        System.out.println("Response are");
        for (int index=0; index < modelfarmasis.size();index++ ){
            int hargajualobat =  Integer.parseInt(modelfarmasis.get(index).getI_sell());
            if (hargajualobat <= 2000){
                jumlahdata++;
                System.out.println("\nname : " + modelfarmasis.get(index).getI_name());
                System.out.println("price sell : "+ modelfarmasis.get(index).getI_sell());
                System.out.println("barcode"+ modelfarmasis.get(index).getI_barcode());
            }
        }
        System.out.println("\nJumlah data : " + jumlahdata);
    }
}
