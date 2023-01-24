BEGIN{
count=0;
}
{
if($1=="d")
count++
} END{
printf("The Total no of Packets Dropped due to Congestion :%d\n\n", count)
}
