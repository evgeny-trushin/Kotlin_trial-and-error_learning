//error: expecting an element 
if (args.size > 0) {
	println("Args: " + $args[0])
	println("Args: " + args.get(0))
	println("Args: ${args[0]}")
	println("Args: ${args.get(0)}")
} else {
	println("Args are empty")
}