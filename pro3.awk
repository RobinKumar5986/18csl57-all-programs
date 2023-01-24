BEGIN{}
{
if($61="cwnd_")
{ printf("%f\t%f\n",$1,$7); }
}
END{}
