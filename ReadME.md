```
fun testListOn(context: Context): AlarmUiState {
return AlarmUiState(
list = JsonToObjectGenerator<AlarmListItem>()
.getListByFile(context, "alarmList.json", AlarmListItem::class.java)
)
}
```