
# Rapport

**Skriv din rapport här!**

Skapade en recyclerview och la till en URL, man behöver också en viewholder där behövs de varibler som som även skulle
skrivas ut i recyclerviewItem. jag har använt mig av name och size. 




Här lägger jag till listan som jag vill ska skapas för att sedan hämta ur information ur.
```
 @Override
    public void onPostExecute(String json) {

        Gson gson = new Gson();
        /*mountain = gson.fromJson(json, Mountain.class);*/
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> tempList = gson.fromJson(json, type);
        Log.d("MainActivity", json);
        //List <Mountain> list = new ArrayList<>();
        mountain.addAll(tempList);
        //adapter.setMountains(mountain);
        adapter.notifyDataSetChanged();
```

```
 @Override
    public void onPostExecute(String json) {

        Gson gson = new Gson();
        /*mountain = gson.fromJson(json, Mountain.class);*/
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> tempList = gson.fromJson(json, type);
        Log.d("MainActivity", json);
        //List <Mountain> list = new ArrayList<>();
        mountain.addAll(tempList);
        //adapter.setMountains(mountain);
        adapter.notifyDataSetChanged();
```

Här skrivs det strings ut som jag kommer att använda mig av i arraylist. 
``` 
        @SerializedName("ID")
        private String ID;
        private String name;
        private String type;
        /*private String company;
        private String location;
        private String category;*/
        @SerializedName("size")
        private String size;
        private Auxdata auxdata;
```

Här talar jag om vad som ska gås igenom, i detta fallet size, den kommer då igenom hur mycket plats som tas upp och returnera innehållet. 
```  
          @Override
    public int getItemCount() {
        return mountains.size();
    }
```



Bilder läggs i samma mapp som markdown-filen.

![](Screenshot_20220511_143314.png)

Läs gärna:

- Boulos, M.N.K., Warren, J., Gong, J. & Yue, P. (2010) Web GIS in practice VIII: HTML5 and the canvas element for interactive online mapping. International journal of health geographics 9, 14. Shin, Y. &
- Wunsche, B.C. (2013) A smartphone-based golf simulation exercise game for supporting arthritis patients. 2013 28th International Conference of Image and Vision Computing New Zealand (IVCNZ), IEEE, pp. 459–464.
- Wohlin, C., Runeson, P., Höst, M., Ohlsson, M.C., Regnell, B., Wesslén, A. (2012) Experimentation in Software Engineering, Berlin, Heidelberg: Springer Berlin Heidelberg.
