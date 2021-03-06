package com.example.crud_sqlite_semana_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class detalle_articulos extends AppCompatActivity {

    private TextView tv_codigo, tv_descripcion, tv_precio;
    private TextView tv_codigo1, tv_descripcion1, tv_precio1, tv_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_articulos);

        tv_codigo = (TextView) findViewById(R.id.tv_codigo);
        tv_descripcion = (TextView) findViewById(R.id.tv_descripcion);
        tv_precio = (TextView) findViewById(R.id.tv_precio);

        tv_codigo1 = (TextView) findViewById(R.id.tv_codigo1);
        tv_descripcion1 = (TextView) findViewById(R.id.tv_descripcion1);
        tv_precio1 = (TextView) findViewById(R.id.tv_precio1);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);

        Bundle objeto = getIntent().getExtras();
        Dto dto = null;
        if (objeto != null) {
            dto = (Dto) objeto.getSerializable("articulo");
            tv_codigo.setText("" + dto.getCodigo());
            tv_descripcion.setText(dto.getDescripcion());
            tv_precio.setText(String.valueOf(dto.getPrecio()));

            tv_codigo1.setText("" + dto.getCodigo());
            tv_descripcion1.setText(dto.getDescripcion());
            tv_precio1.setText(String.valueOf(dto.getPrecio()));
            tv_fecha.setText("Fecha de creación: " + getDateTime());
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_Lista_Articulos) {
            Intent spinnerActivity = new Intent(this, consulta_spinner.class);
            startActivity(spinnerActivity);
            return true;
        } else if (id == R.id.action_Lista_Articulos1) {
            Intent ListViewActivity = new Intent(this, list_view_articulos.class);
            startActivity(ListViewActivity);
            return true;
        } /*else if (id == R.id.RecycleView) {
            //Intent ListViewActivity = new Intent(MainActivity.this, consulta_recyclerView.class);
            //startActivity(ListViewActivity);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


}