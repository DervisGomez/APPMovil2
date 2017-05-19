package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private TabHost tabs;
	private Button btnBuscar;
	private EditText etBuscar;
	private EditText contrato;//CONTRATO
	private EditText nombre;//NOMBRE
	private EditText cc;//CC
	private EditText direccionContrato;//DIRECCIONCONTRATO
	private EditText telefono;//TELEFONOS
	private EditText atraso;//ATRASOS
	private EditText uso;//USO
	private EditText estrato;//ESTRATO
	private EditText saldo;//SALDO
	private EditText unidadesResidenciales;//UNIDRESIDENCIALES
	private EditText unidadesNoResidenciales;//UNIDNORESIDENCIALES
	
	private EditText cicloFactura;// CICLOFACTURACION
	private EditText cicloConsumo;//CICLOCONSUMO
	private EditText direccionCorrespondencia;//DIRECCIONCORRESPONDENCIA
	private EditText rutaLectura;//RUTALECTURA
	private EditText rutaReparto;//RUTAREPARTO
	
	private EditText productoAcueducto;//PRODACUEDUCTO
	private EditText estadoAcueducto;//ESTADOCORTEP45
	private EditText productoAlcantarillado;//PRODALCANTARILLADO
	private EditText estadoAlcantarillado;//ESTADOCORTEP46
	
	private EditText numeroMedidor;//IDMEDIDOR
	private EditText serialMedidor;//SERIALMEDIDOR
	private EditText fechaInstalacion;//FINSTALACIÓN
	private EditText tipoMedidor;//TIPOMEDIDOR
	private EditText totalizador;//TOTALIZADOR
	private EditText medidoresHijos;//SERIALESMEDIDORESHIJOS
	private EditText pdoFacturacion;//PDOFACTURACIÓN
	
	private boolean buscando=false;	
	private LinearLayout tab1;
	private LinearLayout tab2;
	private LinearLayout tab3;
	private LinearLayout tab4;
	private ProgressBar pb1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		setContentView(R.layout.activity_main);
		
		Resources res = getResources();
		
		tabs=(TabHost)findViewById(android.R.id.tabhost);
		etBuscar=(EditText)findViewById(R.id.etBuscar);
		btnBuscar=(Button)findViewById(R.id.btnBuscar);
		btnBuscar.setOnClickListener(this);
		btnBuscar=(Button)findViewById(R.id.btnBuscar2);
		btnBuscar.setOnClickListener(this);
		btnBuscar=(Button)findViewById(R.id.btnBuscar3);
		btnBuscar.setOnClickListener(this);
		btnBuscar=(Button)findViewById(R.id.btnBuscar4);
		btnBuscar.setOnClickListener(this);
		pb1=(ProgressBar)findViewById(R.id.pBar);
		pb1.setVisibility(View.GONE);
		
		tabs.setup();
		iniciarTabs();
		iniciarEditTex();
		tabInvisible();
		
		
		
		tabs.setOnTabChangedListener(new OnTabChangeListener() {
		    @Override
		    public void onTabChanged(String tabId) {
		    	String buscar=etBuscar.getText().toString();
		    	switch (Integer.valueOf(tabId)){
		    	case 1:
		    		etBuscar=(EditText)findViewById(R.id.etBuscar);
		    		btnBuscar=(Button)findViewById(R.id.btnBuscar);
		    		
		    		break;
		    	case 2:
		    		etBuscar=(EditText)findViewById(R.id.etBuscar2);
		    		btnBuscar=(Button)findViewById(R.id.btnBuscar2);
		    		break;
		    	case 3:
		    		etBuscar=(EditText)findViewById(R.id.etBuscar3);
		    		btnBuscar=(Button)findViewById(R.id.btnBuscar3);
		    		break;
		    	case 4:
		    		etBuscar=(EditText)findViewById(R.id.etBuscar4);
		    		btnBuscar=(Button)findViewById(R.id.btnBuscar4);
		    		break;
		    	}
		        etBuscar.setText(buscar);
		    }
		}); 
	}
	
	public void tabInvisible(){
		LinearLayout tab1;
		tab1=(LinearLayout)findViewById(R.id.tab11);
		tab1.setVisibility(View.GONE);
		tab1=(LinearLayout)findViewById(R.id.tab21);
		tab1.setVisibility(View.GONE);
		tab1=(LinearLayout)findViewById(R.id.tab31);
		tab1.setVisibility(View.GONE);
		tab1=(LinearLayout)findViewById(R.id.tab41);
		tab1.setVisibility(View.GONE);
	}
	
	public void tabVisible(){
		LinearLayout tab1;
		tab1=(LinearLayout)findViewById(R.id.tab11);
		tab1.setVisibility(View.VISIBLE);
		tab1=(LinearLayout)findViewById(R.id.tab21);
		tab1.setVisibility(View.VISIBLE);
		tab1=(LinearLayout)findViewById(R.id.tab31);
		tab1.setVisibility(View.VISIBLE);
		tab1=(LinearLayout)findViewById(R.id.tab41);
		tab1.setVisibility(View.VISIBLE);
	}
	
	public void iniciarEditTex(){
		this.contrato = (EditText)findViewById(R.id.etContrato);
		this.nombre = (EditText)findViewById(R.id.etNombre);
		this.cc = (EditText)findViewById(R.id.etCc);
		this.direccionContrato = (EditText)findViewById(R.id.etDdireccionContrato);
		this.telefono = (EditText)findViewById(R.id.etTelefono);
		this.atraso = (EditText)findViewById(R.id.etAtraso);
		this.uso = (EditText)findViewById(R.id.etUso);
		this.estrato = (EditText)findViewById(R.id.etEstrato);
		this.saldo = (EditText)findViewById(R.id.etSaldo);
		this.unidadesResidenciales = (EditText)findViewById(R.id.etUnidadesResidenciales);
		this.unidadesNoResidenciales = (EditText)findViewById(R.id.etUnidadesNoResidenciales);
		
		this.cicloFactura = (EditText)findViewById(R.id.etCicloFactura);
		this.cicloConsumo = (EditText)findViewById(R.id.etCicloConsumo);
		this.direccionCorrespondencia = (EditText)findViewById(R.id.etDireccionCorrespondencia);
		this.rutaLectura = (EditText)findViewById(R.id.etRutaLectura);
		this.rutaReparto = (EditText)findViewById(R.id.etRutaReparto);
		
		this.productoAcueducto = (EditText)findViewById(R.id.etProductoAcueducto);
		this.estadoAcueducto = (EditText)findViewById(R.id.etEstadoAcueducto);
		this.productoAlcantarillado = (EditText)findViewById(R.id.etProductoAlcantarillado);
		this.estadoAlcantarillado = (EditText)findViewById(R.id.etEstadoAlcantarillado);
		
		this.numeroMedidor = (EditText)findViewById(R.id.etNumeroMedidor);
		this.serialMedidor = (EditText)findViewById(R.id.etSerialMedidor);
		this.fechaInstalacion = (EditText)findViewById(R.id.etFechaInstalacion);
		this.tipoMedidor = (EditText)findViewById(R.id.etTipoMedidor);
		this.totalizador = (EditText)findViewById(R.id.etTotalizador);
		this.medidoresHijos = (EditText)findViewById(R.id.etMedidoresHijo);
		this.pdoFacturacion = (EditText)findViewById(R.id.etFactura);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void iniciarTabs(){
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		if(height<width){
			width=height;
		}
		String[] pestana=new String[4];
		if (width<400){
			pestana[0]="Usua.";
			pestana[1]="Fact.";
			pestana[2]="Prod.";
			pestana[3]="Medi.";
		}else{
			pestana[0]="Usuario";
			pestana[1]="Factura";
			pestana[2]="Producto";
			pestana[3]="Medidor";
		}
		TabHost.TabSpec spec=tabs.newTabSpec("1");
		spec.setContent(R.id.tab1);
		spec.setIndicator(pestana[0],null);
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("2");
		spec.setContent(R.id.tab2);
		spec.setIndicator(pestana[1],null);
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("3");
		spec.setContent(R.id.tab3);
		spec.setIndicator(pestana[2],null);
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("4");
		spec.setContent(R.id.tab4);
		spec.setIndicator(pestana[3],null);
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
	}
	
	@Override
	public void onClick(View v) {
		String buscar=etBuscar.getText().toString();
		VerificarConexion verificar=new VerificarConexion(this);
		if(!buscando){
			if(buscar.length()>0){
				if(verificar.estaConectado()){
					buscando=true;
					pb1.setVisibility(View.VISIBLE);
					tabInvisible();
					new MiTarea("{contrato:"+buscar+"}").execute();
				}else{
					showAlertDialog(this, "Conexion a Internet",
							"Tu Dispositivo no tiene Conexion a Internet.", false);
				}
			}else{
				Toast t=Toast.makeText(this, "Introducir Codigo", Toast.LENGTH_SHORT);
				t.show();
			}
		}else{
//			showAlertDialog(this, "Contrato",
//					"Buscando Contrato.", false);
		}
		
		
	}
	public void iniciar(String dato){
		if(dato.length()>2){
			Contrato(dato);
		}else{
			showAlertDialog(this, "Contrato", "No se encontro coincidencia con el codigo ingresado",false);
		}
		pb1.setVisibility(View.GONE);
		buscando=false;
	}
	
	public void Contrato(String datos) {
		// TODO Auto-generated constructor stub
		JsonParser parser = new JsonParser();
 		Object obje = parser.parse(datos);
 		JsonArray array=(JsonArray)obje;
 		if(!array.isJsonNull()){
 			for (int x=0;x<array.size();x++){
 	 			JsonObject objO=array.get(x).getAsJsonObject();
 	 			if (!(objO.get("CONTRATO").isJsonNull())) {
 	 				contrato.setText(objO.get("CONTRATO").getAsString());
 	 				tabVisible();
// 	 				showAlertDialog(this, "Contrato"+objO.get("CONTRATO").getAsString(), "Fue encontrado exitosamente",false);
 				}else{
 					contrato.setText("");
 				}if (!(objO.get("NOMBRE").isJsonNull())) {
 	 				nombre.setText(objO.get("NOMBRE").getAsString());
 				}else{
 					nombre.setText("");
 				} if (!(objO.get("CC").isJsonNull())) {
 	 				cc.setText(objO.get("CC").getAsString());
 				}else{
 					cc.setText("");
 				}if (!(objO.get("DIRECCIONCONTRATO").isJsonNull())) {
 	 				direccionContrato.setText(objO.get("DIRECCIONCONTRATO").getAsString());
 				}else{
 					direccionContrato.setText("");
 				}if (!(objO.get("TELEFONOS").isJsonNull())) {
 	 				telefono.setText(objO.get("TELEFONOS").getAsString());
 				}else{
 					telefono.setText("");
 				}if (!(objO.get("ATRASOS").isJsonNull())) {
 	 				atraso.setText(objO.get("ATRASOS").getAsString());
 				}else{
 					atraso.setText("");
 				}if (!(objO.get("USO").isJsonNull())) {
 	 				uso.setText(objO.get("USO").getAsString());
 				}else{
 					uso.setText("");
 				}if (!(objO.get("ESTRATO").isJsonNull())) {
 	 				estrato.setText(objO.get("ESTRATO").getAsString());
 				}else{
 					estrato.setText("");
 				}if (!(objO.get("SALDO").isJsonNull())) {
 	 				saldo.setText(objO.get("SALDO").getAsString());
 				}else{
 					saldo.setText("");
 				}if (!(objO.get("UNIDRESIDENCIALES").isJsonNull())) {
 	 				unidadesResidenciales.setText(objO.get("UNIDRESIDENCIALES").getAsString());
 				}else{
 					unidadesResidenciales.setText("");
 				}if (!(objO.get("UNIDNORESIDENCIALES").isJsonNull())) {
 	 				unidadesNoResidenciales.setText(objO.get("UNIDNORESIDENCIALES").getAsString());
 				}else{
 					unidadesNoResidenciales.setText("");
 				}
 				
 				if (!(objO.get("CICLOFACTURACION").isJsonNull())) {
 	 				cicloFactura.setText(objO.get("CICLOFACTURACION").getAsString());
 				}else{
 					cicloFactura.setText("");
 				}if (!(objO.get("CICLOCONSUMO").isJsonNull())) {
 	 				cicloConsumo.setText(objO.get("CICLOCONSUMO").getAsString());
 				}else{
 					cicloConsumo.setText("");
 				}if (!(objO.get("DIRECCIONCORRESPONDENCIA").isJsonNull())) {
 	 				direccionCorrespondencia.setText(objO.get("DIRECCIONCORRESPONDENCIA").getAsString());
 				}else{
 					direccionCorrespondencia.setText("");
 				}if (!(objO.get("RUTALECTURA").isJsonNull())) {
 	 				rutaLectura.setText(objO.get("RUTALECTURA").getAsString());
 				}else{
 					rutaLectura.setText("");
 				}if (!(objO.get("RUTAREPARTO").isJsonNull())) {
 	 				rutaReparto.setText(objO.get("RUTAREPARTO").getAsString());
 				}else{
 					rutaReparto.setText("");
 				}
 				
 				if (!(objO.get("PRODACUEDUCTO").isJsonNull())) {
 	 				productoAcueducto.setText(objO.get("PRODACUEDUCTO").getAsString());
 				}else{
 					productoAcueducto.setText("");
 				}if (!(objO.get("ESTADOCORTEP45").isJsonNull())) {
 	 				estadoAcueducto.setText(objO.get("ESTADOCORTEP45").getAsString());
 				}else{
 					estadoAcueducto.setText("");
 				}if (!(objO.get("PRODALCANTARILLADO").isJsonNull())) {
 	 				productoAlcantarillado.setText(objO.get("PRODALCANTARILLADO").getAsString());
 				}else{
 					productoAlcantarillado.setText("");
 				}if (!(objO.get("ESTADOCORTEP46").isJsonNull())) {
 	 				estadoAlcantarillado.setText(objO.get("ESTADOCORTEP46").getAsString());
 				}else{
 					estadoAlcantarillado.setText("");
 				}
 				
 				if (!(objO.get("IDMEDIDOR").isJsonNull())) {
 	 				numeroMedidor.setText(objO.get("IDMEDIDOR").getAsString());
 				}else{
 					numeroMedidor.setText("");
 				}if (!(objO.get("SERIALMEDIDOR").isJsonNull())) {
 	 				serialMedidor.setText(objO.get("SERIALMEDIDOR").getAsString());
 				}else{
 					serialMedidor.setText("");
 				}if (!(objO.get("FINSTALACIÓN").isJsonNull())) {
 	 				fechaInstalacion.setText(objO.get("FINSTALACIÓN").getAsString());
 				}else{
 					fechaInstalacion.setText("");
 				}if (!(objO.get("TIPOMEDIDOR").isJsonNull())) {
 	 				tipoMedidor.setText(objO.get("TIPOMEDIDOR").getAsString());
 				}else{
 					tipoMedidor.setText("");
 				}if (!(objO.get("TOTALIZADOR").isJsonNull())) {
 	 				totalizador.setText(objO.get("TOTALIZADOR").getAsString());
 				}else{
 					totalizador.setText("");
 				}if (!(objO.get("SERIALESMEDIDORESHIJOS").isJsonNull())) {
 	 				medidoresHijos.setText(objO.get("SERIALESMEDIDORESHIJOS").getAsString());
 				}else{
 					medidoresHijos.setText("");
 				}if (!(objO.get("PDOFACTURACIÓN").isJsonNull())) {
 	 				pdoFacturacion.setText(objO.get("PDOFACTURACIÓN").getAsString());
 				}else{
 					pdoFacturacion.setText("");
 				}
 			}
 		}else{
 			showAlertDialog(this, "Contrato", "No se encontro coincidencia con el codigo ingresado",false);
 		}
	}

	public void showAlertDialog(Context context, String title, String message, Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		 
		alertDialog.setTitle(title);
		 
		alertDialog.setMessage(message);
		 
//		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
		 
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		 
		alertDialog.show();
	}
	
private class MiTarea extends AsyncTask<String, Float, String>{
	 private String ur;
	 public MiTarea(String x){
		 this.ur="https://appexp.akc.co/api/servlet/datamap/DATUSUA1/"+x;
		 
	 }
  protected void onPreExecute() {

   }

   protected String doInBackground(String... urls) {
  	 String responce = "";
       BufferedReader rd = null;
       try {
           URL url = new URL(ur);
           rd = new BufferedReader(new InputStreamReader(url.openStream()));
           String line;
           while ((line = rd.readLine()) != null) {
               responce += line;
           }

       } catch (Exception e) {
    	   
       } finally {
           if (rd != null) {
               try {
                   rd.close();
               } catch (IOException ex) {
            	   
               }
           }
       }
       return responce;
   }

   protected void onProgressUpdate (Float... valores) {

   }

   protected void onPostExecute(String tiraJson) {
   	iniciar(tiraJson);
   	
   }
}

}
