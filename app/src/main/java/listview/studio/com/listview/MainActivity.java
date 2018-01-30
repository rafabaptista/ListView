package listview.studio.com.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens = { "Campinas", "SP", "Barueri", "Santos", "Rio de Janeiro", "Piracicaba", "Paris", "Pequim" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView)findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, //esse cara esta dentro do layour padrao simple_list_item_1
                itens
        );

        listaItens.setAdapter(adapter);

        //onClick da lista
        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int codigoPosition = i; // i = position do ListView
                String valorClicado = listaItens.getItemAtPosition(codigoPosition).toString();

                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
