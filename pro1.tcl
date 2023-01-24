set ns [new Simulator]

set tr [open p1.tr w]
$ns trace-all $tr

set nam [open p1.nam w]
$ns namtrace-all $nam

proc finish {} {
	global ns tr nam
	$ns flush-trace
	close $tr
	close $nam
	exec nam p1.nam &
	exit 0
}
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

$n0 label "Source 1"
$n3 label "Source 2"
$n1 label "Router"
$n2 label "Destination"

$n0 color "blue"
$n1 color "green"
$n2 color "Red"
$n3 color "blue"

$ns color 1 "orange"
$ns color 2 "brown"

$ns simplex-link $n0 $n1 100Mb 100ms DropTail
$ns simplex-link $n1 $n2 100Mb 100ms DropTail
$ns simplex-link $n3 $n1 100Mb 100ms DropTail

$ns queue-limit $n0 $n1 7
$ns queue-limit $n1 $n2 2
$ns queue-limit $n3 $n1 7

set udp [new Agent/UDP]
$ns attach-agent $n0 $udp

set udp1 [new Agent/UDP]
$ns attach-agent $n3 $udp1

set null [new Agent/Null]
$ns attach-agent $n2 $null

$ns connect $udp $null
$ns connect $udp1 $null

set crb [new Application/Traffic/CBR]
$crb attach-agent $udp

set crb1 [new Application/Traffic/CBR]
$crb1 attach-agent $udp1

$crb set packetSize_ 5000
$crb set interval_ 0.001
$udp set class_ 1

$crb1 set packetSize_ 5000
$crb1 set interval_ 0.001
$udp1 set class_ 2

$ns at 0.0 "$crb start"
$ns at 0.9 "$crb stop"

$ns at 0.0 "$crb1 start"
$ns at 0.9 "$crb1 stop"

$ns at 1.0 "finish"
$ns run
