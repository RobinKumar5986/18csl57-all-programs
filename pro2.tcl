set ns [new Simulator]

set tr [open p2.tr w]
$ns trace-all $tr

set nam [open p2.nam w]
$ns namtrace-all $nam

proc finish {} {
	global ns tr nam
	$ns flush-trace 
	close $tr
	close $nam
	exec nam p2.nam &
	exit 0
}
$ns color 1 "red"
$ns color 2 "green"
$ns color 3 "blue"
$ns color 4 "brown"
$ns color 5 "orange"
$ns color 6 "yellow"

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

$ns duplex-link $n1 $n0 10Mb 100ms DropTail
$ns duplex-link $n2 $n0 10Mb 100ms DropTail
$ns duplex-link $n3 $n0 10Mb 100ms DropTail
$ns duplex-link $n4 $n0 10Mb 100ms DropTail
$ns duplex-link $n5 $n0 10Mb 100ms DropTail
$ns duplex-link $n6 $n0 10Mb 100ms DropTail

Agent/Ping instproc recv {from rtt} {
#$self instvar node_
#puts "node [$node_ id] reciving ping answer from $from with rtt $rtt ms"
}

set p1 [new Agent/Ping]
set p2 [new Agent/Ping]
set p3 [new Agent/Ping]
set p4 [new Agent/Ping]
set p5 [new Agent/Ping]
set p6 [new Agent/Ping]

$ns attach-agent $n1 $p1
$ns attach-agent $n2 $p2
$ns attach-agent $n3 $p3
$ns attach-agent $n4 $p4
$ns attach-agent $n5 $p5
$ns attach-agent $n6 $p6

$ns queue-limit $n4 $n0 1
$ns queue-limit $n5 $n0 1
$ns queue-limit $n6 $n0 1

$ns connect $p1 $p4
$ns connect $p2 $p5
$ns connect $p3 $p6

$p1 set packetSize_ 500000
$p2 set packetSize_ 500000
$p3 set packetSize_ 500000
$p4 set packetSize_ 500000
$p5 set packetSize_ 500000
$p6 set packetSize_ 500000

$p1 set class_ 1
$p2 set class_ 2
$p3 set class_ 3
$p4 set class_ 4
$p5 set class_ 5
$p6 set class_ 6


$p1 set interval_ 0.001
$p2 set interval_ 0.001
$p3 set interval_ 0.001
$p4 set interval_ 0.001
$p5 set interval_ 0.001
$p6 set interval_ 0.001


$ns at 0.1 "$p1 send"
$ns at 0.3 "$p2 send"
$ns at 0.5 "$p3 send"
$ns at 0.7 "$p4 send"
$ns at 0.9 "$p5 send"
$ns at 1.1 "$p6 send"

$ns at 0.2 "$p1 send"
$ns at 0.4 "$p2 send"
$ns at 0.6 "$p3 send"
$ns at 0.8 "$p4 send"
$ns at 1.0 "$p5 send"
$ns at 1.2 "$p6 send"

$ns at 3.2 "finish"
$ns run
